package com.tw.obc.unit;

// Understands scale of 3D odbjects
public class Volume extends ScaledUnit<Volume> {
    public static final Volume  L = new Volume( "l", 1000);
    public static final Volume ML = new Volume("ml", 1);

    public Volume(String name, int scale) {
        super(name, scale);
    }

}