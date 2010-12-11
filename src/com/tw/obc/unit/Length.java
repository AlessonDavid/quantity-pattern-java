package com.tw.obc.unit;

// Understands scale of 1D objects
public class Length extends ScaledUnit<Length> {
    public static final Length  KILOMETER = new Length("km", 1000000);
    public static final Length      METER = new Length( "m", 1000);
    public static final Length CENTIMETER = new Length("cm", 10);
    public static final Length MILLIMETER = new Length("mm", 1);

    private Length(String name, int scale) {
        super(name, scale);
    }

}