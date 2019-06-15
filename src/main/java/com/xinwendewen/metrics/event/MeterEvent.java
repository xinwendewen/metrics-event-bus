package com.xinwendewen.metrics.event;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;

public interface MeterEvent {
    Meter.Type getType();

    String getName();

    Tags getTags();

    void report(MeterRegistry meterRegistry);
}
