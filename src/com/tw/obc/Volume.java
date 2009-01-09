package com.tw.obc;

import java.math.BigDecimal;

// Understands measurement of 3D objects
public class Volume {

    private BigDecimal value;
    private VolumeUnit unit;

    Volume(BigDecimal value, VolumeUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Volume in(VolumeUnit otherUnit) {
        return new Volume(value, unit);
    }

    @Override
    public boolean equals(Object other) {
        return (other == this) || ((getClass() == other.getClass()) && equals((Volume)other));
    }

    private boolean equals(Volume other) {
        return (other != null) && (other.in(this.unit).value.compareTo(this.value) == 0);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.value != null ? this.value.hashCode() : 0);
        hash = 79 * hash + (this.unit != null ? this.unit.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return value + unit.name();
    }

}