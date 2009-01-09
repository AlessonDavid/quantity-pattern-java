package com.tw.obc;

import java.math.BigDecimal;

// Understands a scale of measurement
public abstract class Unit<U extends Unit> {

    public final String name;

    public Unit(String name) {
        this.name = name;
    }

    public abstract BigDecimal convertValueTo(BigDecimal value, U other);

    public Measurement<U> s(double value) {
        return new Measurement(BigDecimal.valueOf(value), this);
    }

}