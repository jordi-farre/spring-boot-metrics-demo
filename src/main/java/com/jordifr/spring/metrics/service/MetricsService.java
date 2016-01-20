package com.jordifr.spring.metrics.service;

import com.jordifr.spring.metrics.entity.ActionEnum;

/**
 * Created by jordi on 19/01/16.
 */
public interface MetricsService {

    public void execute(ActionEnum action);

}
