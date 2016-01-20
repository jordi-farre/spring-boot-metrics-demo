package com.jordifr.spring.metrics.scheduler;

import com.jordifr.spring.metrics.entity.ActionEnum;
import com.jordifr.spring.metrics.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by jordi on 19/01/16.
 */
@Component
public class MetricsScheduler {

    @Autowired
    private MetricsService metricsService;

    @Scheduled(fixedDelay = 10)
    public void executeMetrics() {
        Random random = new Random();
        ActionEnum actionEnum = ActionEnum.getEnum(random.nextInt(ActionEnum.values().length));
        this.metricsService.execute(actionEnum);
    }

}
