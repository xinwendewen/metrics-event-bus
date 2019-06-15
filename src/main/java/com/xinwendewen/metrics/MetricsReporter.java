package com.xinwendewen.metrics;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.xinwendewen.metrics.event.MeterEvent;
import io.micrometer.core.instrument.MeterRegistry;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class MetricsReporter {
    private final MeterRegistry meterRegistry;
    private final EventBus eventBus;

    @Inject
    public MetricsReporter(MeterRegistry meterRegistry, EventBus eventBus) {
        this.meterRegistry = meterRegistry;
        this.eventBus = eventBus;
    }

    @PostConstruct
    public void init() {
        eventBus.register(this);
    }

    @Subscribe
    public void handleMeterEvent(MeterEvent meterEvent) {
        meterEvent.report(meterRegistry);
    }
}
