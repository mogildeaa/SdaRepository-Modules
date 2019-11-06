package com.sda.interfaces;

public class Motocicleta implements IMotor, ICaroserie {
    @Override
    public String getTip() {
        return "Cruiser";
    }

    @Override
    public String getCilindree() {
        return "600 (0.6)";
    }
}
