package com.tw.obc;

import java.math.BigDecimal;

// Understands magnitude translations from a given scale
public class ScalingConverter implements Converter {
    private BigDecimal scale;

    public ScalingConverter(BigDecimal scale) {
        this.scale = scale;
    }

    @Override
    public BigDecimal convertValueTo(BigDecimal value, BigDecimal scale) {
        return value.multiply(this.scale).divide(scale);
    }
}
