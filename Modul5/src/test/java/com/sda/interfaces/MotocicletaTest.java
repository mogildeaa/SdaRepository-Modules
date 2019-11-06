package com.sda.interfaces;

import org.junit.Test;

import static org.junit.Assert.*;

public class MotocicletaTest {

    private Motocicleta motocicleta = new Motocicleta();

    @Test
    public void getTip() {
        assertEquals("Cruiser", motocicleta.getTip());
    }

    @Test
    public void getCilindree() {
        assertEquals("600 (0.6)", motocicleta.getCilindree());
    }
}