package com.tw.obc;

import java.math.BigDecimal;

// Understands a scale of measurement
public abstract class Unit<U extends Unit<U>> {

    private final String name;

    public Unit(String name) {
        this.name = name;
    }

    public abstract BigDecimal convertValueTo(BigDecimal value, U other);

    @SuppressWarnings("unchecked")
    public final Measurement<U> s(double value) {
        return new Measurement<U>(BigDecimal.valueOf(value), (U)this);
    }

    @Override
    public String toString() {
        return name;
    }

}