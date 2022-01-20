package com.bibi;

import org.junit.jupiter.api.Test;

import static com.bibi.Main.fact;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void Testfact() {
        assertEquals(1, fact(1));
        assertEquals(6, fact(3));

    }

    @Test
    void testNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            fact(-1);
        });
    }
}