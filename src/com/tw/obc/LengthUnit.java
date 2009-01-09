package com.tw.obc;

// Understands scale of 1D objects
import java.math.BigDecimal;

public class LengthUnit extends Unit<LengthUnit> {
    public static final LengthUnit KM = new LengthUnit("km", 1000000);
    public static final LengthUnit  M = new LengthUnit( "m", 1000);
    public static final LengthUnit CM = new LengthUnit("cm", 10);
    public static final LengthUnit MM = new LengthUnit("mm", 1);

    public final BigDecimal scale;

    private LengthUnit(String name, int scale) {
        super(name);
        this.scale = new BigDecimal(scale);
    }

    @Override
    public BigDecimal convertValueTo(BigDecimal value, LengthUnit other) {
        return value.multiply(this.scale).divide(other.scale);
    }

}