package com.sda.enums;

public class Highway {

    private LengthUnit unit;
    private int length;

    public Highway(LengthUnit unit, int length) {
        this.unit = unit;
        this.length = length;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    public int getLength() {
        return length;
    }
}
