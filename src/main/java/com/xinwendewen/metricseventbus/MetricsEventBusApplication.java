package com.xinwendewen.metricseventbus;

import com.xinwendewen.metrics.MetricsReporter;
import com.xinwendewen.metrics.event.TimerEvent;
import io.micrometer.core.instrument.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class MetricsEventBusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetricsEventBusApplication.class, args);
    }

    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @Autowired
    MetricsReporter metricsReporter;

    @Bean
    ApplicationRunner applicationRunner() {
        return arg -> {
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    metricsReporter.handleMeterEvent(new TimerEvent() {
                        @Override
                        public Duration getDuration() {
                            return Duration.ofMillis((long) (Math.random() * 10));
                        }

                        @Override
                        public String getName() {
                            return "a-timer";
                        }

                        @Override
                        public Tags getTags() {
                            return null;
                        }
                    });
                }
            }, 0, 1, TimeUnit.SECONDS);
        };
    }
}
