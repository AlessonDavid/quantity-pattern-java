package com.tw.obc;

// Understands scale of 1D objects
import java.math.BigDecimal;

public class Length extends Unit<Length> {
    public static final Length KM = new Length("km", 1000000);
    public static final Length  M = new Length( "m", 1000);
    public static final Length CM = new Length("cm", 10);
    public static final Length MM = new Length("mm", 1);

    public final BigDecimal scale;

    private Length(String name, int scale) {
        super(name);
        this.scale = new BigDecimal(scale);
    }

    @Override
    public BigDecimal convertValueTo(BigDecimal value, Length other) {
        return value.multiply(this.scale).divide(other.scale);
    }

}