package com.tw.obc;

// Understands scale of a length
public enum Unit {
    M(1000), CM(10), MM(1);

    public final int scale;

    Unit(int scale) {
        this.scale = scale;
    }

    public Length s(int value) {
        return new Length(value, this);
    }
}