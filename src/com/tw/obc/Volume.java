package com.tw.obc;

// Understands scale of 3D odbjects
import java.math.BigDecimal;

public class Volume extends Unit<Volume> {
    public static Volume L = new Volume("l", 1);

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