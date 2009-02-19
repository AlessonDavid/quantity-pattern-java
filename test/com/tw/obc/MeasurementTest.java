package com.tw.obc;

import com.tw.obc.unit.Length;
import com.tw.obc.unit.ScaledUnit;
import com.tw.obc.unit.Temperature;
import com.tw.obc.unit.Weight;
import com.tw.obc.unit.Volume;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsNot.*;

public class MeasurementTest {

    @Test
    public void shouldConvert1MTo1M() {
        assertThat(Length.M.s(1), is(Length.M.s(1).in(Length.M)));
    }

    @Test
    public void shouldConvert1MTo100CM() {
        assertThat(Length.CM.s(100), is(Length.M.s(1).in(Length.CM)));
    }

    @Test
    public void shouldConvert100CMTo1M() {
        assertThat(Length.M.s(1), is(Length.CM.s(100).in(Length.M)));
    }

    @Test
    public void shouldConvert2500CMTo25M() {
        assertThat(Length.M.s(25), is(Length.CM.s(2500).in(Length.M)));
    }

    @Test
    public void shouldConvert11MTo1100CM() {
        assertThat(Length.M.s(25), is(Length.CM.s(2500).in(Length.M)));
    }

    @Test
    public void shouldConvert1CMTo10MM() {
        assertThat(Length.MM.s(10), is(Length.CM.s(1).in(Length.MM)));
    }

    @Test
    public void shouldCreateLengthUsingFactoryMethodInUnit() {
        assertThat(Length.M.s(1), is(Length.M.s(1)));
    }

    @Test
    public void shouldEquate1MWith100CM() {
        assertThat(Length.CM.s(100), is(Length.M.s(1)));
    }

    @Test
    public void shouldEquate12MWith1200CM() {
        assertThat(Length.CM.s(1200), is(Length.M.s(12)));
    }

    @Test
    public void shouldEquate15MWith15000MM() {
        assertThat(Length.MM.s(15000), is(Length.M.s(15)));
    }

    @Test
    public void shouldEquate1KMWith1000000M() {
        assertThat(Length.MM.s(1000000), is(Length.KM.s(1)));
    }

    @Test
    public void shouldGive1KMWhen100CMAddedTo999M() {
        assertThat(Length.KM.s(1), is(Length.M.s(999).plus(Length.CM.s(100))));
    }

    @Test
    public void shouldGive500CMWhen100MMDeductedFrom510CM() {
        assertThat(Length.CM.s(500), is(Length.CM.s(510).minus(Length.MM.s(100))));
    }

    @Test
    public void shouldAllowFloatingPointArithmeticOnLength() {
        assertThat(Length.CM.s(1.0d), is(Length.CM.s(1)));
        assertThat(Length.CM.s(1.1d), is(Length.MM.s(11).in(Length.CM)));
        assertThat(Length.KM.s(0.005d), is(Length.M.s(5)));
        assertThat(Length.KM.s(1d), is(Length.KM.s(0.5d).plus(Length.M.s(500))));
    }

    @Test
    public void shouldYeildAppropriateHashCodes() {
        assertThat(Length.M.s(1).hashCode(), is(Length.M.s(1).hashCode()));
        assertThat(Length.M.s(1).hashCode(), is(not(Length.M.s(2).hashCode())));
    }

    @Test
    public void shouldDealInVolumesToo() {
        assertThat(Volume.L.s(1), is(Volume.L.s(1).in(Volume.L)));
        assertThat(Volume.L.s(0.001), is(Volume.ML.s(1).in(Volume.L)));
        assertThat(Volume.ML.s(1500), is(Volume.L.s(0.8).plus(Volume.ML.s(700))));
    }

    @Test
    public void shouldDealInTemperaturesToo() {
        assertThat(Temperature.C.s(1), is(Temperature.C.s(1).in(Temperature.C)));
        assertThat(Temperature.C.s(0), is(Temperature.K.s(273)));
        assertThat(Temperature.C.s(-10), is(Temperature.C.s(10).minus(Temperature.C.s(20))));
        assertThat(Temperature.C.s(100), is(Temperature.K.s(323).plus(Temperature.C.s(-223))));
    }

    @Test
    public void shouldDealInWeights() {
        assertThat(Weight.G.s(100), is(Weight.KG.s(0.1d)));
    }

    @Test
    public void shouldNotEquateMeasuresOfDifferentUnits() {
        final Measurement measure = Length.M.s(1);
        final Measurement other = Volume.L.s(1);
        assertThat(measure, is(not(other)));
    }

    @Test
    public void shoudlStillBeAbleToUseConstructor() {
        final Measurement measure = new Measurement<Length>(1.0, Length.M);
        final Measurement other = Length.M.s(1.0);
        assertThat(measure, is(other));
    }

}