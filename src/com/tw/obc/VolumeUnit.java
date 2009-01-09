package com.tw.obc;

// Understands scale of 3D odbjects

import java.math.BigDecimal;

public enum VolumeUnit {
    L;

    public Volume s(double value) {
        return new Volume(BigDecimal.valueOf(value), this);
    }
}