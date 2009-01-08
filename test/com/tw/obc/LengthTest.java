package com.tw.obc;

import static org.junit.Assert.*;
import org.junit.Test;

public class LengthTest {

    @Test
    public void shouldConvert1MTo1M() {
        assertEquals(new Length(1, Length.Unit.M), new Length(1, Length.Unit.M).in(Length.Unit.M));
    }

    @Test
    public void shouldConvert1MTo100CM() {
        assertEquals(new Length(100, Length.Unit.CM), new Length(1, Length.Unit.M).in(Length.Unit.CM));
    }

    @Test
    public void shouldConvert100CMTo1M() {
        assertEquals(new Length(1, Length.Unit.M), new Length(100, Length.Unit.CM).in(Length.Unit.M));
    }

    @Test
    public void shouldConvert2500CMTo25M() {
        assertEquals(new Length(25, Length.Unit.M), new Length(2500, Length.Unit.CM).in(Length.Unit.M));
    }

    @Test
    public void shouldConvert11MTo1100CM() {
        assertEquals(new Length(25, Length.Unit.M), new Length(2500, Length.Unit.CM).in(Length.Unit.M));
    }

    @Test
    public void shouldConvert1CMTo10MM() {
        assertEquals(new Length(10, Length.Unit.MM), new Length(1, Length.Unit.CM).in(Length.Unit.MM));
    }

    @Test
    public void shouldCreateLengthUsingFactoryMethodInUnit() {
        assertEquals(new Length(1, Length.Unit.M), Length.Unit.M.s(1));
    }

}