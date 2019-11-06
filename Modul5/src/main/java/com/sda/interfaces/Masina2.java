package com.sda.interfaces;

public class Masina2 extends ACaroserie implements IMotor{

    @Override
    public String getTip() {
        return "Cabrio";
    }

    @Override
    public String getCilindree() {
        return "4.7 Hemi";
    }
}
