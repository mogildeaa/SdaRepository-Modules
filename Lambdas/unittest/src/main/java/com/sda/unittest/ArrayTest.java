package com.sda.unittest;

import org.junit.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ArrayTest {

    private String[] target = {"Ionel", "Gigel", "Dorel", "Fanel"};

    /**
     * creati o metoda care verifica dimensiunea array-ului
     * array size = 4;
     * array contine valoarea Dorel
     * array-ul nu contine valoarea Ion
     */
    @Test
    public void testArray() {
        boolean isContained = false;
        assertEquals(4, target.length);
        for (String temp : target) {
            if (temp == "Dorel") {
                isContained = true;
                assertEquals("Arrayul contine pe Dorel", true, isContained);
            }
            if (temp != "Ionel") {
                isContained = false;
            }
        }
        assertEquals("Ionel nu este in array",false, isContained);
    }

    //alternativ
    private boolean testNameContained (String name){
        boolean present = false;
        return present = Stream.of(target)
                .anyMatch(item -> item.equals(name));
    }

    @Test
    public void testArrayWithAssertJ(){
        //todo
        assertThat(target)
                .hasSize(4)
                .contains("Dorel")
                .doesNotContain("Ion");
    }
}
