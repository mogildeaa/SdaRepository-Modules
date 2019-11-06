package com.sda.unittest;

public class Calculator {

    private int x;
    private int y;

    public Calculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int aduna() {
        return x + y;
    }

    public int aduna(int a, int b) {
        return a + b;
    }

    public int imparte(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by 0");
        } else {
            return a / b;
        }
    }
}
