package com.tw.obc;

// Understands scale of 1D objects
import java.math.BigDecimal;

public enum LengthUnit {
    KM(1000000), M(1000), CM(10), MM(1);

    public final BigDecimal scale;

    LengthUnit(int scale) {
        this.scale = new BigDecimal(scale);
    }

    public Length s(double value) {
        return new Length(BigDecimal.valueOf(value), this);
    }
}