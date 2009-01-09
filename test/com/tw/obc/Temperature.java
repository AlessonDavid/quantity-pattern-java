package com.tw.obc;

// Understands 

import java.math.BigDecimal;

class Temperature extends Unit<Temperature> {
    public static final Temperature C = new Temperature("C", 0);
    public static final Temperature K = new Temperature("K", -273);

    private BigDecimal translation;

    private Temperature(String name, int translation) {
        super(name);
        this.translation = new BigDecimal(translation);
    }

    @Override
    public BigDecimal convertValueTo(BigDecimal value, Temperature other) {
        return value.add(this.translation).subtract(other.translation);
    }

}
