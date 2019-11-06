package com.sda.java8.Sorting;

public class InsertionSort {
    public static int key;

    public static int[] sort(int[] array) {
        insertionSort(array);
        return array;
    }

    public static void insertionSort(int[] array) {
        for (int current = 1; current < array.length; current++) {
            key = array[current];
            int previous = current - 1;
            while ((previous >= 0) && (array[previous] > key)) {
                array[previous + 1] = array[previous];
                previous--;
            }
            array[previous + 1] = key;
        }
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
    }
}


