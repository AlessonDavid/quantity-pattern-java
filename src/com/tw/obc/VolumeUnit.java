package com.tw.obc;

// Understands scale of 3D odbjects
import java.math.BigDecimal;

public class VolumeUnit extends Unit<VolumeUnit> {
    public static VolumeUnit L = new VolumeUnit("l", 1);

    private BigDecimal scale;

    public VolumeUnit(String name, int scale) {
        super(name);
        this.scale = new BigDecimal(scale);
    }

    @Override
    public BigDecimal convertValueTo(BigDecimal value, VolumeUnit other) {
        return value.multiply(this.scale).divide(other.scale);
    }
}