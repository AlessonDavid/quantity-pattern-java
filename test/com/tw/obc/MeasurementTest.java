package com.tw.obc;

import org.junit.Ignore;
import static org.junit.Assert.*;
import org.junit.Test;

public class MeasurementTest {

    @Test
    public void shouldConvert1MTo1M() {
        assertEquals(Length.M.s(1), Length.M.s(1).in(Length.M));
    }

    @Test
    public void shouldConvert1MTo100CM() {
        assertEquals(Length.CM.s(100), Length.M.s(1).in(Length.CM));
    }

    @Test
    public void shouldConvert100CMTo1M() {
        assertEquals(Length.M.s(1), Length.CM.s(100).in(Length.M));
    }

    @Test
    public void shouldConvert2500CMTo25M() {
        assertEquals(Length.M.s(25), Length.CM.s(2500).in(Length.M));
    }

    @Test
    public void shouldConvert11MTo1100CM() {
        assertEquals(Length.M.s(25), Length.CM.s(2500).in(Length.M));
    }

    @Test
    public void shouldConvert1CMTo10MM() {
        assertEquals(Length.MM.s(10), Length.CM.s(1).in(Length.MM));
    }

    @Test
    public void shouldCreateLengthUsingFactoryMethodInUnit() {
        assertEquals(Length.M.s(1), Length.M.s(1));
    }

    @Test
    public void shouldEquate1MWith100CM() {
        assertEquals(Length.CM.s(100), Length.M.s(1));
    }

    @Test
    public void shouldEquate12MWith1200CM() {
        assertEquals(Length.CM.s(1200), Length.M.s(12));
    }

    @Test
    public void shouldEquate15MWith15000MM() {
        assertEquals(Length.MM.s(15000), Length.M.s(15));
    }

    @Test
    public void shouldEquate1KMWith1000000M() {
        assertEquals(Length.MM.s(1000000), Length.KM.s(1));
    }

    @Test
    public void shouldGive1KMWhen100CMAddedTo999M() {
        assertEquals(Length.KM.s(1), Length.M.s(999).plus(Length.CM.s(100)));
    }

    @Test
    public void shouldGive500CMWhen100MMDeductedFrom510CM() {
        assertEquals(Length.CM.s(500), Length.CM.s(510).minus(Length.MM.s(100)));
    }

    @Test
    public void shouldAllowFloatingPointArithmeticOnLength() {
        assertEquals(Length.CM.s(1.0d), Length.CM.s(1));
        assertEquals(Length.CM.s(1.1d), Length.MM.s(11).in(Length.CM));
        assertEquals(Length.KM.s(0.005d), Length.M.s(5));
        assertEquals(Length.KM.s(1d), Length.KM.s(0.5d).plus(Length.M.s(500)));
    }

    @Test
    public void shouldYeildAppropriateHashCodes() {
        assertEquals(Length.M.s(1), Length.M.s(1));
        assertNotEquals(Length.M.s(1), Length.M.s(2));
    }

    @Test
    public void shouldDealInVolumesToo() {
        assertEquals(Volume.L.s(1), Volume.L.s(1).in(Volume.L));
        assertEquals(Volume.L.s(0.001), Volume.ML.s(1).in(Volume.L));
        assertEquals(Volume.ML.s(1500), Volume.L.s(0.8).plus(Volume.ML.s(700)));
    }

    @Test
    public void shouldDealInTemperaturesToo() {
        assertEquals(Temperature.C.s(1), Temperature.C.s(1).in(Temperature.C));
        assertEquals(Temperature.C.s(0), Temperature.K.s(273));
        assertEquals(Temperature.C.s(-10), Temperature.C.s(10).minus(Temperature.C.s(20)));
        assertEquals(Temperature.C.s(100), Temperature.K.s(323).plus(Temperature.C.s(-223)));
    }

    @Test
    public void shouldDealInWeights() {
        assertEquals(Weight.G.s(100), Weight.KG.s(0.1d));
    }

    @Test
    public void shouldNotEquateMeasuresOfDifferentUnits() {
        assertNotEquals(Length.M.s(1), Volume.L.s(1));
    }

    private void assertNotEquals(Object expected, Object actual) {
        assertFalse(expected.equals(actual));
    }
}