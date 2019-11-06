package com.sda.java8.Sorting;

public class BubbleSort {
    private int[] myArray;
    private int temp;

    public BubbleSort(int[] myArray) {
        this.myArray = myArray;
    }

    void startSort() {
        boolean executat;
        do {
            executat = false;
            for (int i = 0; i < myArray.length - 1; i++) {
                if (myArray[i] > myArray[i + 1]) {
                    temp = myArray[i];
                    myArray[i] = myArray[i + 1];
                    myArray[i + 1] = temp;
                    executat = true;
                }
            }
        } while (executat);
        for (int j = 0; j < myArray.length; j++) {
            System.out.print(myArray[j] + " ");
        }
        System.out.println(" ");
    }
}
