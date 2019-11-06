package com.sda.enums;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Highway a1 = new Highway(LengthUnit.KILOMETER, 110);
        Highway a2 = new Highway(LengthUnit.CENTIMETER, 300_000_000);
        Highway a16 = new Highway(LengthUnit.METER, 1);

        List<Highway> highways = new LinkedList<>();

        highways.add(a1);
        highways.add(a2);
        highways.add(a16);

        for (Highway temp : highways) {
            switch (temp.getUnit()) {
                case METER:
                    System.out.println("A16 has " + temp.getLength() * 0.001 + " km");
                    break;
                case KILOMETER:
                    System.out.println("A1 has " + temp.getLength() + " km");
                    break;
                case CENTIMETER:
                    System.out.println("A2 has " + temp.getLength() / 1_000_000 + " km");
                    break;
                default:
                    System.out.println("Unit not recognized");
            }
        }

        printEnumValues();
    }

    static void printEnumValues(){
        /*Obtinem toate valorile numului apeland metoda values() - mostenita din
        * clasa Enum. (java.lang)*/
        LengthUnit[] units = LengthUnit.values();

        for(LengthUnit temp: units){
            System.out.println(temp);
        }
    }
}
