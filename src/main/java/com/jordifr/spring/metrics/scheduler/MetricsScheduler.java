package com.jordifr.spring.metrics.scheduler;

import com.jordifr.spring.metrics.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by jordi on 19/01/16.
 */
@Component
public class MetricsScheduler {

    @Autowired
    private MetricsService metricsService;

    @Scheduled(fixedDelay = 1000)
    public void executeMetrics() {
        String fileName = "TEST_" + System.currentTimeMillis() + ".xml";
        this.metricsService.processFile(fileName);
    }

}
