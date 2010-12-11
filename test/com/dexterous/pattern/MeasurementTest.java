package com.dexterous.pattern;

import static com.dexterous.pattern.unit.Length.*;
import static com.dexterous.pattern.unit.Temperature.*;
import static com.dexterous.pattern.unit.Weight.*;
import static com.dexterous.pattern.unit.Volume.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import com.dexterous.pattern.unit.Length;

import org.junit.Test;

public class MeasurementTest {

    @Test
    public void shouldConvert1MTo1M() {
        assertThat(METER.s(1), is(METER.s(1).in(METER)));
    }

    @Test
    public void shouldConvert1MTo100CM() {
        assertThat(CENTIMETER.s(100), is(METER.s(1).in(CENTIMETER)));
    }

    @Test
    public void shouldConvert100CMTo1M() {
        assertThat(METER.s(1), is(CENTIMETER.s(100).in(METER)));
    }

    @Test
    public void shouldConvert2500CMTo25M() {
        assertThat(METER.s(25), is(CENTIMETER.s(2500).in(METER)));
    }

    @Test
    public void shouldConvert11MTo1100CM() {
        assertThat(METER.s(25), is(CENTIMETER.s(2500).in(METER)));
    }

    @Test
    public void shouldConvert1CMTo10MM() {
        assertThat(MILLIMETER.s(10), is(CENTIMETER.s(1).in(MILLIMETER)));
    }

    @Test
    public void shouldCreateLengthUsingFactoryMethodInUnit() {
        assertThat(METER.s(1), is(METER.s(1)));
    }

    @Test
    public void shouldEquate1MWith100CM() {
        assertThat(CENTIMETER.s(100), is(METER.s(1)));
    }

    @Test
    public void shouldEquate12MWith1200CM() {
        assertThat(CENTIMETER.s(1200), is(METER.s(12)));
    }

    @Test
    public void shouldEquate15MWith15000MM() {
        assertThat(MILLIMETER.s(15000), is(METER.s(15)));
    }

    @Test
    public void shouldEquate1KMWith1000000M() {
        assertThat(MILLIMETER.s(1000000), is(KILOMETER.s(1)));
    }

    @Test
    public void shouldGive1KMWhen100CMAddedTo999M() {
        assertThat(KILOMETER.s(1), is(METER.s(999).plus(CENTIMETER.s(100))));
    }

    @Test
    public void shouldGive500CMWhen100MMDeductedFrom510CM() {
        assertThat(CENTIMETER.s(500), is(CENTIMETER.s(510).minus(MILLIMETER.s(100))));
    }

    @Test
    public void shouldAllowFloatingPointArithmeticOnLength() {
        assertThat(CENTIMETER.s(1.0d), is(CENTIMETER.s(1)));
        assertThat(CENTIMETER.s(1.1d), is(MILLIMETER.s(11).in(CENTIMETER)));
        assertThat(KILOMETER.s(0.005d), is(METER.s(5)));
        assertThat(KILOMETER.s(1d), is(KILOMETER.s(0.5d).plus(METER.s(500))));
    }

    @Test
    public void shouldYeildAppropriateHashCodes() {
        assertThat(METER.s(1).hashCode(), is(METER.s(1).hashCode()));
        assertThat(METER.s(1).hashCode(), is(not(METER.s(2).hashCode())));
    }

    @Test
    public void shouldDealInVolumesToo() {
        assertThat(LITRE.s(1), is(LITRE.s(1).in(LITRE)));
        assertThat(LITRE.s(0.001), is(MILLILITRE.s(1).in(LITRE)));
        assertThat(MILLILITRE.s(1500), is(LITRE.s(0.8).plus(MILLILITRE.s(700))));
    }

    @Test
    public void shouldDealInTemperaturesToo() {
        assertThat(CELCIUS.s(1), is(CELCIUS.s(1).in(CELCIUS)));
        assertThat(CELCIUS.s(0), is(KELVIN.s(273)));
        assertThat(CELCIUS.s(-10), is(CELCIUS.s(10).minus(CELCIUS.s(20))));
        assertThat(CELCIUS.s(100), is(KELVIN.s(323).plus(CELCIUS.s(-223))));
    }

    @Test
    public void shouldDealInWeights() {
        assertThat(GRAM.s(100), is(KILOGRAM.s(0.1d)));
    }

    @Test
    public void shouldNotEquateMeasuresOfDifferentUnits() {
        final Measurement measure = METER.s(1);
        final Measurement other = LITRE.s(1);
        assertThat(measure, is(not(other)));
    }

    @Test
    public void shoudlStillBeAbleToUseConstructor() {
        final Measurement measure = new Measurement<Length>(1.0, METER);
        final Measurement other = METER.s(1.0);
        assertThat(measure, is(other));
    }

}