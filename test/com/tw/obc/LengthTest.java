package com.tw.obc;

import static org.junit.Assert.*;
import org.junit.Test;

public class LengthTest {

    @Test
    public void shouldConvert1MTo1M() {
        assertEquals(new Length(1, Length.Unit.M), new Length(1, Length.Unit.M).in(Length.Unit.M));
    }

}