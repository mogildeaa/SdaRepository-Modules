package com.sda.hotel;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Receptie {

    Hotel h;

    public Receptie(Hotel h) {
        this.h = h;
    }

    private void showMenu() {
        System.out.println("Alegeti o tasta: ");
        System.out.println("1. Pentru a face o rezervare");
        System.out.println("2. Pentru a afisa toate rezervarile hotelului");
        System.out.println("3. Pentru a inchide aplicatia.");
        System.out.println("4. Pentru a afisa toate rezervarile in ordine alfabetica.");
    }


    public void run() {
        Scanner s = new Scanner(System.in);

        while (true) {
            showMenu();
            String tasta = s.nextLine();
            switch (tasta) {
                case "1":
                    System.out.println("Alege data rezervarii (yyyy-mm-dd)");
                    LocalDate d = LocalDate.parse(s.nextLine());

                    System.out.println("Tastati numele clientului");
                    String nume = s.next();

                    int nrCamera = h.getAvailableRoom(d);
                    System.out.println("Nr camera rezervata: " + nrCamera);

                    if(nrCamera == -1) {
                        System.out.println("Sorry. No room available");
                        break;
                    }
                    h.reserveRoom(nrCamera, d, nume);
                    break;
                case "2":
                    System.out.println(h);
                    break;
                case "3":
                    h.save();
                    return;
                case "4":
                    System.out.println(h.getAllRezervationsSortedByName());
            }
        }
    }
}
