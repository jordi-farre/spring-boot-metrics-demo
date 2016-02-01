package com.jordifr.spring.metrics.service;

import com.codahale.metrics.annotation.Timed;
import com.jordifr.spring.metrics.entity.ActionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by jordi on 19/01/16.
 */
@Service
public class MetricsServiceImpl implements MetricsService {

    private Logger log = LoggerFactory.getLogger(MetricsServiceImpl.class);

    @Autowired
    private CounterService counterService;

    @Autowired
    private GaugeService gaugeService;

    @Async
    @Override
    @Timed(name = "action.time")
    public void execute(ActionEnum action) {
        long init = System.currentTimeMillis();
        Random random = new Random();
        boolean result = random.nextBoolean();
        int delay = random.nextInt(5000);
        // test
        if (result) {
            this.log.info("Action " + action.name() + " finalizado correctamente");
            this.counterService.increment("action." + action.name().toLowerCase() + ".ok");
        } else {
            this.log.info("Action " + action.name() + " finalizado con error");
            this.counterService.increment("action." + action.name().toLowerCase() + ".error");
        }
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            this.log.error("Error al pausar el thread", e);
        }
        long end = System.currentTimeMillis();
        this.gaugeService.submit("action." + action.name().toLowerCase() + ".time", TimeUnit.MILLISECONDS.toSeconds(end - init));
    }

}
