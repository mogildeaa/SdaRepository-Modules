package com.sda.Exceptions.Vehicle;

public class AltMain {

    public static void main(String[] args) {

        Car masina = new Car(100);

        try {
            masina.accelerate(200);
        } catch (CarCrashedException e) {
            e.printStackTrace();
        }
    }
}
