package com.xinwendewen.metrics.event;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;

public interface CounterEvent extends MeterEvent {
    double getIncrement();

    @Override
    default Meter.Type getType() {
        return Meter.Type.COUNTER;
    }

    @Override
    default void report(MeterRegistry meterRegistry) {
        meterRegistry.counter(getName(), getTags()).increment(getIncrement());
    }
}
