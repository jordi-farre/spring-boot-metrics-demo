package com.jordifr.spring.metrics.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by jordi on 19/01/16.
 */
@Service
public class MetricsServiceImplement implements MetricsService {

    private Logger log = LoggerFactory.getLogger(MetricsServiceImplement.class);

    @Autowired
    private CounterService counterService;

    @Override
    public void processFile(String name) {
        Random random = new Random();
        boolean result = random.nextBoolean();
        if (result) {
            this.log.info("Fichero " + name + " procesado correctamente");
            this.counterService.increment("file.process.ok");
        } else {
            this.log.info("Fichero " + name + " procesado con error");
            this.counterService.increment("file.process.error");
        }
    }

}
