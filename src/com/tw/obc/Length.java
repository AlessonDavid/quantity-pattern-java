package com.tw.obc;

// Understands measurement of a single spatial dimension
public class Length {

    private int value;
    private Unit unit;

    public Length(int value,Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length in(Unit targetUnit) {
        return new Length(value * this.unit.scale / targetUnit.scale, targetUnit);
    }

    @Override
    public boolean equals(Object other) {
        return (other == this) || ((getClass() == other.getClass()) && equals((Length)other));
    }

    private boolean equals(Length other) {
        return (other != null) && (other.in(this.unit).value == this.value);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.value;
        hash = 97 * hash + (this.unit != null ? this.unit.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return value + unit.name();
    }

}