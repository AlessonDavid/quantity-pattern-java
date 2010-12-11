package com.dexterous.pattern.unit;

import com.dexterous.pattern.Unit;
import java.math.BigDecimal;

// Understands scale of thermal energy
public class Temperature extends Unit<Temperature> {
    public static final Temperature CELCIUS = new Temperature("C", 0);
    public static final Temperature KELVIN = new Temperature("K", -273);

    private final BigDecimal translation;

    private Temperature(String name, int translation) {
        super(name);
        this.translation = new BigDecimal(translation);
    }

    @Override
    public BigDecimal convertValueTo(BigDecimal value, Temperature other) {
        return value.add(this.translation).subtract(other.translation);
    }

}
