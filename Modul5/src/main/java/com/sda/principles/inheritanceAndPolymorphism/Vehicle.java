package com.sda.principles.inheritanceAndPolymorphism;

public class Vehicle {

    private int maxSpeed;
    private String manufacturer = "Ferrary";

    public String getManufacturer() {
        return manufacturer;
    }

    public Vehicle(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

//    public Vehicle() {
//        this.maxSpeed = 200;
//    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString(){
        return "Vehicle maxSpeed is: " + maxSpeed;
    }
}
