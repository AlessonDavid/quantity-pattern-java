package com.tw.obc;

// Understands scale of 1D objects
public class Length extends ScaledUnit<Length> {
    public static final Length KM = new Length("km", 1000000);
    public static final Length  M = new Length( "m", 1000);
    public static final Length CM = new Length("cm", 10);
    public static final Length MM = new Length("mm", 1);

    private Length(String name, int scale) {
        super(name, scale);
    }

}