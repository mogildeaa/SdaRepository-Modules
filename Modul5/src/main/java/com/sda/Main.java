package com.sda;

import com.sda.interfaces.Masina;
import com.sda.interfaces.Masina2;
import com.sda.interfaces.Motocicleta;
import com.sda.interfaces.Motocicleta2;

/*Mainu asta e pentru INTERFETE (package interfaces)*/
public class Main {

    public static void main(String[] args) {

        /*Acesta este un exemplu: Ambele clase sunt din acleasi pachet daaar, daca avem nume de aceeasi clasa in pachete diferite
        ca sa faci obiectul scrii numele pachetului ca in al 2-lea rand de mai jos*/
        Masina2 masinaDinAbstracte = new Masina2();
        com.sda.interfaces.Masina masinaDinInterfete = new com.sda.interfaces.Masina();

        Motocicleta2 motocicletaDinAbstracte = new Motocicleta2();

        masinaDinAbstracte.getCilindree();
        masinaDinAbstracte.getTip();

        //assert motocicletaDinAbstracte.getTip().equals("Chopper");
        /*Asta de sus nu merge pentru ca iti intoarce null*/
        assert "Chopper".equals(motocicletaDinAbstracte.getTip());
    }
}
