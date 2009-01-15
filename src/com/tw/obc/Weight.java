package com.tw.obc;

import java.math.BigDecimal;

// Understands scale of mass
public class Weight extends Unit<Weight> {
    public static final Weight KG = new Weight("kg", 1000);
    public static final Weight  G = new Weight( "g", 1);



    private BigDecimal scale;

    public Weight(String name, int scale) {
        super(name, new ScalingConverter(new BigDecimal(scale)));
        this.scale = new BigDecimal(scale);
    }

    @Override
    public BigDecimal convertValueTo(BigDecimal value, Weight other) {
        return converter.convertValueTo(value, other.scale);
    }

}
