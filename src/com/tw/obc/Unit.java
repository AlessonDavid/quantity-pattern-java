package com.tw.obc;

// Understands scale of a length

import java.math.BigDecimal;

public enum Unit {
    KM(1000000), M(1000), CM(10), MM(1);

    public final BigDecimal scale;

    Unit(int scale) {
        this.scale = new BigDecimal(scale);
    }

    public Length s(double value) {
        return new Length(BigDecimal.valueOf(value), this);
    }
}