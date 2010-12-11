package com.dexterous.pattern;

import java.math.BigDecimal;

// Understands application of magnitude to unit
public class Measurement<U extends Unit<? super U>> {

    private final BigDecimal magnitude;
    private final U unit;

    Measurement(BigDecimal value, U unit) {
        this.magnitude = value;
        this.unit = unit;
    }

    Measurement(double value, U unit) {
        this(BigDecimal.valueOf(value), unit);
    }

    public Measurement<U> in(U otherUnit) {
        return new Measurement<U>(this.unit.convertValueTo(this.magnitude, otherUnit), otherUnit);
    }

    public Measurement<U> plus(Measurement<U> other) {
        return new Measurement<U>(this.magnitude.add(other.in(this.unit).magnitude), this.unit);
    }

    public Measurement<U> minus(Measurement<U> other) {
        return this.plus(other.negate());
    }

    private Measurement<U> negate() {
        return new Measurement<U>(this.magnitude.negate(), this.unit);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        return (other == this) || (
            other.getClass() == this.getClass() &&
            equals((Measurement<U>)other)
        );
    }

    private boolean equals(Measurement<U> other) {
        return (other != null) && (
            other.unit.getClass() == this.unit.getClass() &&
            other.in(this.unit).magnitude.compareTo(this.magnitude) == 0
        );
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
        return magnitude + unit.toString();
    }

}