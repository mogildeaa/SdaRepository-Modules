package com.sda.abstractClasses;

public class Main {
    public static void main(String[] args) {

        AnAnimal whale1 = new Whale();
        AnAnimal giraffe1 = new Giraffe();

        whale1.eat();
        whale1.sleep();
        giraffe1.eat();
        giraffe1.sleep();
        System.out.println("===================");

        print(giraffe1);
        print(whale1);
    }

    private static void print(AnAnimal animal){
        animal.eat();
        animal.sleep();
    }
}
