package com.sda.enums;

/*
    Tip referinta specific, care accepta o lista predefinita de valori.
 */
public enum LengthUnit {
    //name/value
    CENTIMETER(0.01),
    METER(1),
    KILOMETER(1000),
    DECIMETER(0.1);

    double modifier;

    LengthUnit(double modifier) {
        this.modifier = modifier;
    }


}
