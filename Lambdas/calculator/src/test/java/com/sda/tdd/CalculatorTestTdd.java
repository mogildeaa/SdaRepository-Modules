package com.sda.tdd;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculatorTestTdd {

    private Calculator target = new Calculator();

    @Test
    public void test1() {
        assertEquals(0, target.add(""));
    }

    @Test
    public void test2() {
        assertEquals(0+1+2+3,target.add("0,1,2,3"));
    }

    @Test
    public void test3() {
        assertEquals(100, target.add("100"));
        assertEquals(100, target.add("20,80"));
    }

    @Test
    public void test4() {
        assertEquals(0+1+2+3,target.add("0,1\n2,3"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void test5() {
        target.add("-1,0");
    }

    //teste pentru produs mai sus

    List<String> numbers = new LinkedList<>();

    @Test
    public void testProduct1() {
        assertEquals(0, target.product(numbers));
    }

    @Test ( expected = IllegalArgumentException.class)
    public void testProduct2() {
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        target.product(numbers);
    }

    @Test
    public void testProduct3(){
        numbers.add("5");
        numbers.add("10");
        assertEquals(50, target.product(numbers));
    }

    @Test
    public void testProduct4(){
        numbers.add("1");
        numbers.add("2");
        numbers.add("20");
        numbers.add("21");
        numbers.add("5");
        assertEquals(10, target.product(numbers));

    }
}