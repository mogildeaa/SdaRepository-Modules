package com.sda.hotel;

public class HotelMain {

    public static void main(String[] args) {

        Receptie r = new Receptie(Hotel.load());
        r.run();
    }
}