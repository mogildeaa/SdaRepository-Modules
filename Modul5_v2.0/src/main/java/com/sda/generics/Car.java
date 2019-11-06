package com.sda.generics;

public class Car extends AVehicle implements Comparable<Car>{

    private int maxSpeed;

    public Car(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void repair() {
        System.out.println("Car is repaired");
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.maxSpeed - otherCar.getMaxSpeed();
    }
}
