package com.tw.obc;

import java.math.BigDecimal;

// Understands measurement scale with denominations that vary by fixed factors
public class ScaledUnit<U extends ScaledUnit> extends Unit<ScaledUnit<U>> {
    public final BigDecimal scale;

    public ScaledUnit(String name, int scale) {
        super(name);
        this.scale = new BigDecimal(scale);
    }

    @Override
    public BigDecimal convertValueTo(BigDecimal value, ScaledUnit<U> other) {
        return value.multiply(this.scale).divide(other.scale);
    }

}
