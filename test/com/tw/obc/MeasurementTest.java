package com.tw.obc;

import static com.tw.obc.unit.Length.*;
import static com.tw.obc.unit.Temperature.*;
import static com.tw.obc.unit.Weight.*;
import static com.tw.obc.unit.Volume.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import com.tw.obc.unit.Length;

import org.junit.Test;

public class MeasurementTest {

    @Test
    public void shouldConvert1MTo1M() {
        assertThat(M.s(1), is(M.s(1).in(M)));
    }

    @Test
    public void shouldConvert1MTo100CM() {
        assertThat(CM.s(100), is(M.s(1).in(CM)));
    }

    @Test
    public void shouldConvert100CMTo1M() {
        assertThat(M.s(1), is(CM.s(100).in(M)));
    }

    @Test
    public void shouldConvert2500CMTo25M() {
        assertThat(M.s(25), is(CM.s(2500).in(M)));
    }

    @Test
    public void shouldConvert11MTo1100CM() {
        assertThat(M.s(25), is(CM.s(2500).in(M)));
    }

    @Test
    public void shouldConvert1CMTo10MM() {
        assertThat(MM.s(10), is(CM.s(1).in(MM)));
    }

    @Test
    public void shouldCreateLengthUsingFactoryMethodInUnit() {
        assertThat(M.s(1), is(M.s(1)));
    }

    @Test
    public void shouldEquate1MWith100CM() {
        assertThat(CM.s(100), is(M.s(1)));
    }

    @Test
    public void shouldEquate12MWith1200CM() {
        assertThat(CM.s(1200), is(M.s(12)));
    }

    @Test
    public void shouldEquate15MWith15000MM() {
        assertThat(MM.s(15000), is(M.s(15)));
    }

    @Test
    public void shouldEquate1KMWith1000000M() {
        assertThat(MM.s(1000000), is(KM.s(1)));
    }

    @Test
    public void shouldGive1KMWhen100CMAddedTo999M() {
        assertThat(KM.s(1), is(M.s(999).plus(CM.s(100))));
    }

    @Test
    public void shouldGive500CMWhen100MMDeductedFrom510CM() {
        assertThat(CM.s(500), is(CM.s(510).minus(MM.s(100))));
    }

    @Test
    public void shouldAllowFloatingPointArithmeticOnLength() {
        assertThat(CM.s(1.0d), is(CM.s(1)));
        assertThat(CM.s(1.1d), is(MM.s(11).in(CM)));
        assertThat(KM.s(0.005d), is(M.s(5)));
        assertThat(KM.s(1d), is(KM.s(0.5d).plus(M.s(500))));
    }

    @Test
    public void shouldYeildAppropriateHashCodes() {
        assertThat(M.s(1).hashCode(), is(M.s(1).hashCode()));
        assertThat(M.s(1).hashCode(), is(not(M.s(2).hashCode())));
    }

    @Test
    public void shouldDealInVolumesToo() {
        assertThat(L.s(1), is(L.s(1).in(L)));
        assertThat(L.s(0.001), is(ML.s(1).in(L)));
        assertThat(ML.s(1500), is(L.s(0.8).plus(ML.s(700))));
    }

    @Test
    public void shouldDealInTemperaturesToo() {
        assertThat(C.s(1), is(C.s(1).in(C)));
        assertThat(C.s(0), is(K.s(273)));
        assertThat(C.s(-10), is(C.s(10).minus(C.s(20))));
        assertThat(C.s(100), is(K.s(323).plus(C.s(-223))));
    }

    @Test
    public void shouldDealInWeights() {
        assertThat(G.s(100), is(KG.s(0.1d)));
    }

    @Test
    public void shouldNotEquateMeasuresOfDifferentUnits() {
        final Measurement measure = M.s(1);
        final Measurement other = L.s(1);
        assertThat(measure, is(not(other)));
    }

    @Test
    public void shoudlStillBeAbleToUseConstructor() {
        final Measurement measure = new Measurement<Length>(1.0, M);
        final Measurement other = M.s(1.0);
        assertThat(measure, is(other));
    }

}