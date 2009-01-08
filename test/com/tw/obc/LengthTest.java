package com.tw.obc;

import static org.junit.Assert.*;
import org.junit.Test;

public class LengthTest {

    @Test
    public void shouldConvert1MTo1M() {
        assertEquals(new Length(1, Unit.M), new Length(1, Unit.M).in(Unit.M));
    }

    @Test
    public void shouldConvert1MTo100CM() {
        assertEquals(new Length(100, Unit.CM), new Length(1, Unit.M).in(Unit.CM));
    }

    @Test
    public void shouldConvert100CMTo1M() {
        assertEquals(new Length(1, Unit.M), new Length(100, Unit.CM).in(Unit.M));
    }

    @Test
    public void shouldConvert2500CMTo25M() {
        assertEquals(new Length(25, Unit.M), new Length(2500, Unit.CM).in(Unit.M));
    }

    @Test
    public void shouldConvert11MTo1100CM() {
        assertEquals(new Length(25, Unit.M), new Length(2500, Unit.CM).in(Unit.M));
    }

    @Test
    public void shouldConvert1CMTo10MM() {
        assertEquals(new Length(10, Unit.MM), new Length(1, Unit.CM).in(Unit.MM));
    }

    @Test
    public void shouldCreateLengthUsingFactoryMethodInUnit() {
        assertEquals(new Length(1, Unit.M), Unit.M.s(1));
    }

}