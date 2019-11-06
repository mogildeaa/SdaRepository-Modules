package com.sda.interfaces;

import org.junit.Test;

import static org.junit.Assert.*;

public class MasinaTest {

    private Masina masina = new Masina();

    @Test
    public void testMasina(){
        assertEquals("Berlina", masina.getTip());
        assertEquals("1.2", masina.getCilindree());
    }

//    @Test
//    public void testMotocicleta(){
//        assertEquals("Berlina", masina.getTip());
//    }

}