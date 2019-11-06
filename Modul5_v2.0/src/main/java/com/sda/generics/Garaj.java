package com.sda.generics;

public class Garaj<T extends AVehicle> {

    private T vehicle;

    public Garaj(T vehicle) {
        this.vehicle = vehicle;
    }

    public T getVehicle() {
        return vehicle;
    }

    public void setVehicle(T vehicle) {
        this.vehicle = vehicle;
    }

    public void repair(){
        this.vehicle.repair();
    }
}
