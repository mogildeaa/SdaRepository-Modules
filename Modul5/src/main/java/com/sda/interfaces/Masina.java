package com.sda.interfaces;

/*Keyword implements, pot implementa mai multe interfete*/
public class Masina implements ICaroserie, IMotor{

    @Override
    public String getTip() {
        return "Berlina";
    }

    @Override
    public String getCilindree() {
        return "1.2";
    }
}
