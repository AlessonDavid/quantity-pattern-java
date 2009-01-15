package com.tw.obc;

import java.math.BigDecimal;

// Understands conversion from a specified unit
public interface Converter {

    BigDecimal convertValueTo(BigDecimal value, BigDecimal translation);

}
