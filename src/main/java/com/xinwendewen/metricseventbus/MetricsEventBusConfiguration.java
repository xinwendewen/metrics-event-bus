package com.xinwendewen.metricseventbus;

import com.xinwendewen.metrics.MetricsEventBus;
import com.xinwendewen.metrics.MetricsReporter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsEventBusConfiguration {
    @Bean
    public MetricsEventBus metricsEventBus() {
        return new MetricsEventBus();
    }

    @Bean
    public MetricsReporter metricsReporter(MeterRegistry meterRegistry) {
        return new MetricsReporter(meterRegistry, metricsEventBus());
    }
}
