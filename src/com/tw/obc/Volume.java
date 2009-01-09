package com.tw.obc;

import java.math.BigDecimal;

// Understands scale of 3D odbjects
public class Volume extends Unit<Volume> {
    public static Volume  L = new Volume( "l", 1000);
    public static Volume ML = new Volume("ml", 1);

    private BigDecimal scale;

    public Volume(String name, int scale) {
        super(name);
        this.scale = new BigDecimal(scale);
    }

    @Override
    public BigDecimal convertValueTo(BigDecimal value, Volume other) {
        return value.multiply(this.scale).divide(other.scale);
    }
}