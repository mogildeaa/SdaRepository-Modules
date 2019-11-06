package com.sda.abstractClasses;

public class Giraffe extends AnAnimal {

    @Override
    public void eat() {
        System.out.println("The giraffe chews leafs.");
    }

    @Override
    public void sleep() {
        System.out.println("The giraffe sleeps standing.");
    }
}
