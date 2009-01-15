package com.tw.obc;

import java.math.BigDecimal;

// Understands scale of 3D odbjects
public class Volume extends Unit<Volume> {
    public static Volume  L = new Volume( "l", 1000);
    public static Volume ML = new Volume("ml", 1);

    private BigDecimal scale;

    private Volume(String name, int scale) {
        super(name, new ScalingConverter(new BigDecimal(scale)));
        this.scale = new BigDecimal(scale);
    }

    @Override
    public BigDecimal convertValueTo(BigDecimal value, Volume other) {
        return converter.convertValueTo(value, other.scale);
    }
}