package com.sda.fisiere.serializare;

import java.io.Serializable;

//Serializarea insemana salvarea(scrierea) in fisier a unui obiect Java (clase)
public class Persoana implements Serializable {

    private String nume;
    private int varsta;

    public Persoana(String nume, int varsta) {
        this.nume = nume;
        this.varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }


}
