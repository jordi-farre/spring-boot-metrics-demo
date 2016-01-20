package com.jordifr.spring.metrics.entity;

/**
 * Created by jordi on 20/01/16.
 */
public enum ActionEnum {

    EXP(0), REC(1), ANU(2), CEN(3), CRS(4), DEV(5);

    private int action;

    ActionEnum(int action) {
        this.action = action;
    }

    public int getValue() {
        return this.action;
    }

    public static ActionEnum getEnum(int value) {
        for (ActionEnum actionEnum : values()) {
            if (value == actionEnum.getValue()) {
                return actionEnum;
            }
        }
        return null;
    }

}
