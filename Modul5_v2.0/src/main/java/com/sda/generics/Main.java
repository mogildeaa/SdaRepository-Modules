package com.sda.generics;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //delcarare tip generic dupa java 7 (operatorul diamond sa mai scrii ceva in el e optional)
        List<String> strings = new LinkedList<>();

        String text = "asd";
        int numar = 1;

        strings.add(text);
//        strings.add(numar);//eroare de compilare datorita tipului generic declarat mai sus

        //la lista asta poti sa adaugi orice tip de data/
        // niciodata nu e folosita in practica
        List listaDeStringuri = new LinkedList();

        System.out.println("============================");

        //exemplul de mai jos este pentru a intelege
//        de ce este necesar <Type>
        Car car = new Car(150);

        //exemplu prost
        Box<Object> box = new Box<>(car);
        Object object = box.getObject();
        Car object1 = (Car) object;
        object1.getMaxSpeed();

        //exemplu bun
        Box<Car> carBox = new Box<>(car);
        Car carRetrieved = carBox.getObject();

        GenericBox<AVehicle> genericBox = new GenericBox<>(car);
        AVehicle vehicle = genericBox.getT();

        GenericBox<String> stringGenericBox = new GenericBox<>(new String("ASD"));
        String string = stringGenericBox.getT();

        Car dacia = new Car(189);
        Car audiA3 = new Car(197);

        int compareResult = dacia.compareTo(audiA3);
        if(compareResult < 0 ){
            System.out.println("Audi e mai rapid");
        } else if(compareResult > 0){
            System.out.println("Dacia e mai rapid");
        }else {
            System.out.println("Sunt la fel de rapide");
        }

        System.out.println("============");

        GenericBox<? extends AVehicle> garaj1 = new GenericBox<Car>(dacia);
        /*Accepta de mai sus e exemplu in care orice tip de data
        care extinde AVehicle (tipul de data trebuie sa extinda
        AVehicle (Aka: CONSUMER)*/
        //diferite perspective: Mai jos se asteapta orice clasa care are
//        ca si copil pe Car (Aka: PRODUCER)
        GenericBox<? super Car> garaj2 = new GenericBox<AVehicle>(audiA3);

        Car ferarri = new Car(320);
//        garaj1.setT(ferarri); (apare eroare pentru ca nu avem voie sa setam)
        garaj2.setT(ferarri);
    }
}
