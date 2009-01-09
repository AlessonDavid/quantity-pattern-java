package com.tw.obc;

import static org.junit.Assert.*;
import org.junit.Test;

public class LengthTest {

    @Test
    public void shouldConvert1MTo1M() {
        assertEquals(new Length(1, LengthUnit.M), new Length(1, LengthUnit.M).in(LengthUnit.M));
    }

    @Test
    public void shouldConvert1MTo100CM() {
        assertEquals(new Length(100, LengthUnit.CM), new Length(1, LengthUnit.M).in(LengthUnit.CM));
    }

    @Test
    public void shouldConvert100CMTo1M() {
        assertEquals(new Length(1, LengthUnit.M), new Length(100, LengthUnit.CM).in(LengthUnit.M));
    }

    @Test
    public void shouldConvert2500CMTo25M() {
        assertEquals(new Length(25, LengthUnit.M), new Length(2500, LengthUnit.CM).in(LengthUnit.M));
    }

    @Test
    public void shouldConvert11MTo1100CM() {
        assertEquals(new Length(25, LengthUnit.M), new Length(2500, LengthUnit.CM).in(LengthUnit.M));
    }

    @Test
    public void shouldConvert1CMTo10MM() {
        assertEquals(new Length(10, LengthUnit.MM), new Length(1, LengthUnit.CM).in(LengthUnit.MM));
    }

    @Test
    public void shouldCreateLengthUsingFactoryMethodInUnit() {
        assertEquals(new Length(1, LengthUnit.M), LengthUnit.M.s(1));
    }

    @Test
    public void shouldEquate1MWith100CM() {
        assertEquals(LengthUnit.CM.s(100), LengthUnit.M.s(1));
    }

    @Test
    public void shouldEquate12MWith1200CM() {
        assertEquals(LengthUnit.CM.s(1200), LengthUnit.M.s(12));
    }

    @Test
    public void shouldEquate15MWith15000MM() {
        assertEquals(LengthUnit.MM.s(15000), LengthUnit.M.s(15));
    }

    @Test
    public void shouldEquate1KMWith1000000M() {
        assertEquals(LengthUnit.MM.s(1000000), LengthUnit.KM.s(1));
    }

    @Test
    public void shouldGive1KMWhen100CMAddedTo999M() {
        assertEquals(LengthUnit.KM.s(1), LengthUnit.M.s(999).plus(LengthUnit.CM.s(100)));
    }

    @Test
    public void shouldGive500CMWhen100MMDeductedFrom510CM() {
        assertEquals(LengthUnit.CM.s(500), LengthUnit.CM.s(510).minus(LengthUnit.MM.s(100)));
    }

    @Test
    public void shouldAllowFloatingPointArithmeticOnLength() {
        assertEquals(LengthUnit.CM.s(1.0d), LengthUnit.CM.s(1));
        assertEquals(LengthUnit.CM.s(1.1d), LengthUnit.MM.s(11).in(LengthUnit.CM));
        assertEquals(LengthUnit.KM.s(0.005d), LengthUnit.M.s(5));
        assertEquals(LengthUnit.KM.s(1d), LengthUnit.KM.s(0.5d).plus(LengthUnit.M.s(500)));
    }

    @Test
    public void shouldYeildAppropriateHashCodes() {
        assertEquals(LengthUnit.M.s(1), LengthUnit.M.s(1));
        assertNotEquals(LengthUnit.M.s(1), LengthUnit.M.s(2));
    }

    private void assertNotEquals(Object expected, Object actual) {
        assertFalse(expected.equals(actual));
    }

}