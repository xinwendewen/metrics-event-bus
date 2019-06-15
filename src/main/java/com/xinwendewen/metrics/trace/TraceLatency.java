package com.xinwendewen.metrics.trace;

import lombok.Value;

@Value
public class TraceLatency {
    private final long traceId;
    private final long latency;
}
