package com.xinwendewen.metrics.trace;

import com.google.common.base.Preconditions;

/**
 * Reusable and Not Thread-safe
 */
public class TracedStopWatch {
    private long startTime;
    private long traceId;
    private boolean isRunning;

    public void start(long traceId) {
        Preconditions.checkState(!isRunning, "Timer is running");
        this.traceId = traceId;
        this.startTime = System.nanoTime();
        this.isRunning = true;
    }

    public TraceLatency stop(long traceId) {
        Preconditions.checkState(isRunning, "Timer is not running");
        Preconditions.checkArgument(this.traceId == traceId, "TraceId not equal");
        long durationNano = stop();
        return new TraceLatency(this.traceId, durationNano);
    }

    private long stop() {
        long duration = System.nanoTime() - startTime;
        this.startTime = 0;
        this.isRunning = false;
        return duration;
    }
}
