package com.sda.Exceptions.Vehicle;

public class Car {

    private int maxSpeed;

    public Car(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void accelerate(int newSpeed) throws CarCrashedException {
        if (newSpeed > maxSpeed) {
//            throw new IllegalArgumentException("Speed not supported");
            throw new CarCrashedException("Speed not supported");
        }

        maxSpeed = newSpeed;
    }
}
