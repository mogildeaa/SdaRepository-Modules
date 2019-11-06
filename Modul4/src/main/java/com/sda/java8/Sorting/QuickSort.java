package com.sda.java8.Sorting;

public class QuickSort {

    static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int q /*middle*/ = partition(array, start, end);
            quickSort(array, start, q - 1);
            quickSort(array, q + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int x /*valoarePivot*/ = array[end];
        int i /*indexValoareMaiMicaPivot*/ = start - 1;
        for(int j = start; j <= (end-1); j++) {
            if (array[j] <= x) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
            int temp2 = array[i+1];
            array[i+1]= array[end];
            array[end] = temp2;
        return i+1;
    }

    public static void printArray(int[] array){
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
    }
}
