package com.xinwendewen.metrics;

import com.google.common.eventbus.EventBus;

public class MetricsEventBus extends EventBus {
    private static final String DEFAULT_NAME = "metrics";

    public MetricsEventBus() {
        this(DEFAULT_NAME);
    }

    public MetricsEventBus(String name) {
        super(name);
    }
}
