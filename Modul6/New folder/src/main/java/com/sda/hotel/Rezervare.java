package com.sda.hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;

public class Rezervare implements Serializable,Comparable<Rezervare> {

    private static final long serialVersionUID = 3091514142132259451L;
    LocalDate date;
    public String name;
    int nrRoom;

    @Override
    public int compareTo(Rezervare o) {
        return name.compareTo(o.name);
    }

    public static class ComparatorByName implements Comparator<Rezervare>{
            @Override
            public int compare(Rezervare o1, Rezervare o2) {
                return o1.name.compareTo(o2.name);
            }
        }

        //This is just as an example. You can do the same think without a additional method by putting .reversed() at the end.
        //Este doar ca exemplu. Poti face reversul prin a pune pur si simplu .reversed() la apelul anterior!
    public static class ComparatorByNameReverse implements Comparator<Rezervare>{
        @Override
        public int compare(Rezervare o1, Rezervare o2) {
            return o2.name.compareTo(o1.name);
        }
    }

    Rezervare(LocalDate date, String name, int nrRoom) {
        this.date = date;
        this.name = name;
        this.nrRoom = nrRoom;
    }

    @Override
    public boolean equals(Object x) {
        if (x != null && x instanceof Rezervare) {
            Rezervare tmp = (Rezervare) x;
            return this.date.equals(tmp.date) &&
                    this.nrRoom == tmp.nrRoom;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return date + name;
    }

}
