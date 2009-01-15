package com.tw.obc;

import java.math.BigDecimal;

// Understands scale of 1D objects
public class Length extends Unit<Length> {
    public static final Length KM = new Length("km", 1000000);
    public static final Length  M = new Length( "m", 1000);
    public static final Length CM = new Length("cm", 10);
    public static final Length MM = new Length("mm", 1);

    private BigDecimal scale;

    private Length(String name, int scale) {
        super(name, new ScalingConverter(new BigDecimal(scale)));
        this.scale = new BigDecimal(scale);
    }

    @Override
    public BigDecimal convertValueTo(BigDecimal value, Length other) {
        return converter.convertValueTo(value, other.scale);
    }
}