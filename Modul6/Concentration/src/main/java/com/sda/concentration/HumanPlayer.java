package com.sda.concentration;

import java.util.Scanner;

public class HumanPlayer implements IPlayeri{

    String nume;

    HumanPlayer(String nume){
        this.nume = nume;
    }

    @Override
    public int[] getCoord() {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int[] array = new int[]{a, b};
        return array;
    }
}
