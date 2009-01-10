package com.tw.obc;

// Understands 

import java.math.BigDecimal;

public class ScaledUnit<U extends ScaledUnit> extends Unit<U> {
    public final BigDecimal scale;

    public ScaledUnit(String name, int scale) {
        super(name);
        this.scale = new BigDecimal(scale);
    }

    @Override
    public BigDecimal convertValueTo(BigDecimal value, ScaledUnit other) {
        return value.multiply(this.scale).divide(other.scale);
    }

}
