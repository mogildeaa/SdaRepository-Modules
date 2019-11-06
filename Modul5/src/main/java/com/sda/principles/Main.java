package com.sda.principles;

import com.sda.principles.encapsulation.Person;
import com.sda.principles.inheritanceAndPolymorphism.Car;
import com.sda.principles.inheritanceAndPolymorphism.Vehicle;

//import numePachet.NumeClasa
public class Main {

    public static void main(String[] args){
        //short-cut psvm
        Person myPerson = new Person();

        myPerson.setAge(18);
        System.out.println("Age: " + myPerson.getAge());

        myPerson.setAge(-18);
        System.out.println("Age: " + myPerson.getAge());
        System.out.println("=======================");

        Vehicle myVehicle = new Vehicle(220);
        Car fabia = new Car(320,false);
        Vehicle car2 = new Car(180, true);

        System.out.println(myVehicle.toString());
        System.out.println(fabia.toString());
        System.out.println(car2.toString());
        System.out.println("============================");

        print(car2);
        print(myVehicle);
    }

    public static void print(Vehicle input){
        System.out.println("Received vehicle with: " + "\nmaxSpeed: " +
                input.getMaxSpeed() + "\nManufacturer: " + input.getManufacturer());
    }
}
