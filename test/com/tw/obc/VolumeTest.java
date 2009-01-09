package com.tw.obc;

import org.junit.Test;
import static org.junit.Assert.*;

public class VolumeTest {

    @Test
    public void shouldConvert1LTo1L() {
        assertEquals(VolumeUnit.L.s(1), VolumeUnit.L.s(1).in(VolumeUnit.L));
    }

}