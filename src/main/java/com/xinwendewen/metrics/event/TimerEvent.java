package com.xinwendewen.metrics.event;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;

import java.time.Duration;

public interface TimerEvent extends MeterEvent {
    Duration getDuration();

    @Override
    default Meter.Type getType() {
        return Meter.Type.TIMER;
    }

    @Override
    default void report(MeterRegistry meterRegistry) {
        meterRegistry.timer(getName(), getTags()).record(getDuration());
    }
}
