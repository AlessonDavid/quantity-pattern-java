package com.tw.obc;

import java.math.BigDecimal;

// Understands scale of thermal energy
public class Temperature extends Unit<Temperature> {
    public static final Temperature C = new Temperature("C", 0);
    public static final Temperature K = new Temperature("K", -273);

    private BigDecimal translation;

    private Temperature(String name, int translation) {
        super(name, new TranslatingConverter(new BigDecimal(translation)));
        this.translation = new BigDecimal(translation);
    }

    @Override
    public BigDecimal convertValueTo(BigDecimal value, Temperature other) {
        return converter.convertValueTo(value, other.translation);
    }
}
