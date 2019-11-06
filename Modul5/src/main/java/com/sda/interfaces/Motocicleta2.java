package com.sda.interfaces;

public class Motocicleta2 extends AMotor implements ICaroserie {
    @Override
    public String getTip() {
        return "Chopper";
    }

    @Override
    public String getCilindree() {
        return "1000";
    }
}
