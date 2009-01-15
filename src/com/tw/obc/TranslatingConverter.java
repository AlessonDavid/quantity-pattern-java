package com.tw.obc;

import java.math.BigDecimal;

// Understands magnitude translations from a given scale
public class TranslatingConverter implements Converter {
    private BigDecimal translation;

    public TranslatingConverter(BigDecimal translation) {
        this.translation = translation;
    }

    @Override
    public BigDecimal convertValueTo(BigDecimal value, BigDecimal translation) {
        return value.add(this.translation).subtract(translation);
    }
}
