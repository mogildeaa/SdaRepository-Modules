package com.sda.statics;

public class Client {
    public static int nrOrdine = 0;

    String nume;

    public Client(String nume) {
        this.nume = nume;
        nrOrdine++;
    }

    public static int cresteNrOrdine(){
        nrOrdine++;
        return nrOrdine;
    }
}
