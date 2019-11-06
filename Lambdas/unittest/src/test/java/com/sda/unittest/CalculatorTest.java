package com.sda.unittest;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator target = new Calculator(10, 5);

    @Ignore("Motiv pentru care ignor")
    @Test
    public void testAssert() {
        assert "5" == "5"; //dupa assert se asteapta o conditie boolean
//        assertEquals("Numerele primite nu sunt ok","5", "5 "); //este o clasa care contine metode in Junit care ne ajuta si practic inlocuieste cuvantul asser
        boolean isValid = false;
        assertFalse(isValid);
        String nume = null;
        assertNull(nume);
        assertNotNull(nume);
    }

    @Test
    public void aduna() {
        assertEquals(15, target.aduna());
    }

    @Test
    public void aduna1() {
        assertEquals(30, target.aduna(10, 20));
    }

    @Test(timeout = 3000)
    public void testTimeOut(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = ArithmeticException.class) //poti trimite si mai multi parametrii EX: timeout si expected deodata)
    public void testImparte() {
        assertEquals(2, target.imparte(4, 2));
        target.imparte(10, 0);
    }
}