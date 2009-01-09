package com.tw.obc;

import java.math.BigDecimal;

// Understands application of magnitude to unit
public class Measurement<U extends Unit> {

    private BigDecimal magnitude;
    private U unit;

    Measurement(BigDecimal value, U unit) {
        this.magnitude = value;
        this.unit = unit;
    }

    Measurement(double value, U unit) {
        this(BigDecimal.valueOf(value), unit);
    }

    public Measurement in(U otherUnit) {
        return new Measurement(this.unit.convertValueTo(this.magnitude, otherUnit), otherUnit);
    }

    public Measurement plus(Measurement other) {
        return new Measurement(this.magnitude.add(other.in(this.unit).magnitude), this.unit);
    }

    public Measurement minus(Measurement other) {
        return this.plus(other.negate());
    }

    private Measurement negate() {
        return new Measurement(this.magnitude.negate(), this.unit);
    }

    @Override
    public boolean equals(Object other) {
        return (other == this) || ((getClass() == other.getClass()) && equals((Measurement)other));
    }

    private boolean equals(Measurement other) {
        return (other != null) && (other.in(this.unit).magnitude.compareTo(this.magnitude) == 0);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.magnitude != null ? this.magnitude.hashCode() : 0);
        hash = 97 * hash + (this.unit != null ? this.unit.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return magnitude + unit.name;
    }

}