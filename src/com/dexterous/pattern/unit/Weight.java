package com.dexterous.pattern.unit;

// Understands scale of mass
public class Weight extends ScaledUnit<Weight> {
    public static final Weight     GRAM = new Weight( "g", 1);
    public static final Weight KILOGRAM = new Weight("kg", 1000);

    private Weight(String name, int scale) {
        super(name, scale);
    }

}
