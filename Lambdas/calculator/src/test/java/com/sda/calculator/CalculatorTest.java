package com.sda.calculator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    @Mock
    private Calculator target;

    //alternativa (Spionam clasa:)) )
    private Calculator calculator = new Calculator();
    @Spy
    private Calculator spyCalculator = spy(calculator);

    @Before
    public void setUp() {
        when(target.divide(anyInt(), eq(0))).thenReturn(0);
//        Acelasi lucru si mai jos doar ca m-am dus pe matchers am dat un ALT+ enter si am selectat a 2-a chestie
//        when(target.divide(Matchers.anyInt(),Matchers.eq(0))).thenReturn(0);
        when(target.divide(2, 2)).thenReturn(1);

        //initializaez 'spionul'
        doReturn(0)
                .when(spyCalculator)
                .divide(anyInt(), eq(0));
    }

    @Test
    public void divide() {
        assertEquals(1, target.divide(2, 2));
    }

    @Ignore
    @Test
    public void testZeroDivision() {
        assertEquals(0, target.divide(2, 0));
//        assertEquals(10, target.divide(100, 10));
//        Aici iti da eroare pentru ca nu ai specificat comportamentul in mock
//        Pentru asta folosim Mockito.verify:
        verify(target, times(0)).getDivisionResult(anyInt(), anyInt());
    }

    @Test
    public void testSpy() {
        assertEquals(0, spyCalculator.divide(10,0));
        assertEquals(1, spyCalculator.divide(100,100));

        verify(spyCalculator).getDivisionResult(anyInt(), anyInt());

        /*
        verify (mock, times(x))
        cazul exact o data: verify(mock, times(1)) sau verify(mock)
        cazul minim o data: verify (mock, atLeastOnce()) sau atLeast(x)
        cazul maxim: verify(mock, atMost())
        cazul niciodata: verify(mock, never())
         */
    }
}