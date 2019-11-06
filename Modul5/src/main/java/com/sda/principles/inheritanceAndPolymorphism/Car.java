package com.sda.principles.inheritanceAndPolymorphism;

public class Car extends Vehicle {

    private boolean convertible;

    public Car(int maxSpeed, boolean convertible) {
        super(maxSpeed);
        this.convertible = convertible;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public String toString(){
        return "Car is convertible: " + convertible + " and has maxSpeed: " + super.getMaxSpeed();
    }
}
