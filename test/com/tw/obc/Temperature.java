package com.tw.obc;

// Understands 

import java.math.BigDecimal;

class Temperature extends Unit<Temperature> {
    public static final Temperature C = new Temperature("C", 0);

    private int translation;

    private Temperature(String string, int i) {
        super(string);
        this.translation = i;
    }

    @Override
    public BigDecimal convertValueTo(BigDecimal value, Temperature other) {
        return value;
    }

}
