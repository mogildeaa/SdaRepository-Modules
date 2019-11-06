package com.sda;

import java.util.Scanner;

public class CodeWars1 {

    public static void main(String[] args) {

//        /*char[] array = {'a','b','c','d','f'};
//        char[] array2 = {'O','Q','R','S'};
//
//        findMissingLetter(array);
//        findMissingLetter(array2);*/
////        validatePin("12p4");
//          NaN
////        getMiddle("mitocondria");


        String myString = "tu";
        String myString2 = myString.substring(0,1);
        System.out.println(myString2);

        ExInterviu test = new ExInterviu();
        Scanner sc = new Scanner(System.in);
        String pin = sc.next();

        if(test.verifyPin(pin)){
            System.out.println("E adevarat");
        } else {
            System.out.println("Mai baga o fisa!");
        }
    }

    public static String getMiddle(String word) {
        String[] splitInArray = word.split("");
        String middleElement = "";
        if (splitInArray.length % 2 == 0) {
            for (int i = 0; i < splitInArray.length ; i++) {
                if(i == (splitInArray.length / 2)) {
                    String middleElement1 = splitInArray[i-1];
                    String middleElement2 = splitInArray[i];
                    middleElement = middleElement.concat(middleElement1).concat(middleElement2);
                }
            }
        } else {
            for (int i = 0; i < splitInArray.length; i++) {
                if(i == (splitInArray.length / 2)) {
                    middleElement = splitInArray[i];
                }
            }
        }
        return middleElement;
    }

    public static char findMissingLetter(char[] array) {
        char missingChar = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int temp = Character.valueOf(array[i]);
            int temp2 = Character.valueOf(array[i + 1]);

            if (temp2 - temp == 2) {
                temp2--;
                array[i] = (char) temp2;
                missingChar = array[i];
            }
        }
        return missingChar;
    }

    public static boolean validatePin(String pin) {

        if ((pin.length() == 4) || (pin.length() == 6)) {
            String[] charPin = pin.split("");
            for (int i = 0; i <= charPin.length - 1; i++) {
                System.out.println(charPin[i]);
                if (!charPin[i].matches(".*\\d.*")) {
                    return false;
                }
            }
            int pinDigits = Integer.parseInt(pin);
            return true;
        } else {
            return false;
        }
    }
}
