package com.sda.hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {

    private static final long serialVersionUID = -7719649347533111463L;
    int nr;
    List<Rezervare> rezervari;

    Room(int nr) {
        this.nr = nr;
        rezervari = new ArrayList<Rezervare>();
    }

    public boolean reserve(LocalDate date, String name) {

        Rezervare x = new Rezervare(date, name, nr);
        if(rezervari.contains(x)){
            return false;
        } else{
            rezervari.add(x);
            return true;
        }
    }

    @Override
    public String toString(){
        return "" + nr + rezervari;
    }

    public boolean isAvailable(LocalDate date) {
        Rezervare r = new Rezervare(date, "", nr);
        return rezervari.contains(r) == false;
    }

    public List<Rezervare> getAllReservations() {
        return rezervari;
    }
}
