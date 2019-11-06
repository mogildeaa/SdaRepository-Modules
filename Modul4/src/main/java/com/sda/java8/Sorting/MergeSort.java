package com.sda.java8.Sorting;

public class MergeSort {
    public static int[] sort(int[] array) {
        mergeSortRecursive(array, 0, array.length - 1);
        return array;
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }

    private static void mergeSortRecursive(int[] array, int p /*start*/, int r /*final*/) {
        if (p < r) {
            int q /*middle*/ = (p + r) / 2;
            mergeSortRecursive(array, p, q);
            mergeSortRecursive(array, q + 1, r);
            merge(array, p, q, r);
        }
    }

    private static void merge(int[] array, int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < left.length; i++) {
            left[i] = array[p + i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = array[q + j + 1];
        }

        int i = 0;
        int j = 0;
        for (int k = p; k < r; k++) {
            if (left[i] <= right[j]) {
                array[k] = left[i++];
                if (i == n1) {
                    while(++k <= r){
                        array[k] = right[j++];
                    }
                }
            } else {
                array[k] = right[j++];
                if (j == n2) {
                    while(++k <= r){
                        array[k] = left[i++];
                    }
                }
            }
        }

        for (int pula = p; pula <= r; pula++) {
            System.out.print(array[pula] + " ");
        }
        System.out.println();
    }
}
