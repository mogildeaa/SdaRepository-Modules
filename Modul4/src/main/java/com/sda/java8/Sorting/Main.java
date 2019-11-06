package com.sda.java8.Sorting;


import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] nume = {"Catalin", "Iana", "Dan", "Edmond", "George", "Gabriel", "Tudor", "Diana", "Robert",};
        bubbleSortString(nume);
        quickSortString(nume, 0, nume.length-1);


//        quickSort();
//        insertionSort();
//        mergeSort();
//        bubbleSort();
//        generate(100);
//        quickSort(generateReversed(100));
    }

    private static void quickSortString(String[] array, int start, int end) {
        if (start < end) {
            int q /*middle*/ = plm(array, start, end);
            quickSortString(array, start, q - 1);
            quickSortString(array, q + 1, end);
        }
    }


        static int plm (String[] array,int start, int end){
            String x /*valoarePivot*/ = array[end];
            int i /*indexValoareMaiMicaPivot*/ = start - 1;
            for (int j = start; j <= (end - 1); j++) {
                if (array[j].compareTo(x) <= 0) {
                    i++;
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            String temp2 = array[i + 1];
            array[i + 1] = array[end];
            array[end] = temp2;
            return i + 1;
        }

        public static void printArray ( int[] array){
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + " ");
            }
        }


    private static void bubbleSortString(String[] myString) {
//        for (int i = 0; i < myString.length; i++) {
//            System.out.println(myString[i] + " ");
//        }

        boolean executat;
        do {
            executat = false;
            for (int i = 0; i < myString.length - 1; i++) {
                if (myString[i].compareTo(myString[i + 1]) > 0) {
                    String temp = myString[i];
                    myString[i] = myString[i + 1];
                    myString[i + 1] = temp;
                    executat = true;
                }
            }
        } while (executat);

        for (int j = 0; j < myString.length - 1; j++) {
            System.out.print(myString[j] + " ");
        }
    }

    private static int[] generateReversed(int a) {
//        Random random = new Random();
//        int[] randomArray = new int[a];
//        for (int i = 0; i < randomArray.length; i++) {
//            int r = random.nextInt(a);
//            //Codul de mai jos verifica si are grija sa nu se genereze acelasi numar random in Array
//            int j = 0;
//            while (j < i) {
//                if (r == randomArray[j]) {
//                    j = 0;
//                    r = random.nextInt(a);
//                } else {
//                    j++;
//                }
//            }
//            randomArray[i] = r;
//            System.out.print(randomArray[i] + " ");
//        }

        int[] myArray = new int[a];
        for (int i = (myArray.length - 1); i >= 0; i--) {
            myArray[i] = i;
            System.out.print(myArray[i] + " ");
        }
        return myArray;
    }

    private static void generate(int a) {
        LocalTime acum = LocalTime.now();
        System.out.println(acum);

        Random random = new Random();
        int[] randomArray = new int[a];
        for (int i = 0; i < randomArray.length; i++) {
            int r = random.nextInt(a);
            //Codul de mai jos verifica si are grija sa nu se genereze acelasi numar random in Array
//            int j = 0;
//            while (j < i) {
//                if (r == randomArray[j]) {
//                    j = 0;
//                    r = random.nextInt(a);
//                } else {
//                    j++;
//                }
//            }
            randomArray[i] = r;
            System.out.print(randomArray[i] + " ");
        }

        LocalTime dupa = LocalTime.now();
        System.out.println(" ");
        System.out.println(dupa);
        int diferenta = (int) ChronoUnit.MILLIS.between(acum, dupa);
        System.out.println("Nr de milisecunde in care s-a generat array-ul : " + diferenta);
    }

    private static void quickSort(int[] myArray) {
        LocalTime acum = LocalTime.now();
        System.out.println(acum);

//        int[] myArray = {9, 8, 7, 5, 4, 1, 3, 234, 232, 12312};
        QuickSort.quickSort(myArray, 0, myArray.length - 1);
        QuickSort.printArray(myArray);

        LocalTime dupa = LocalTime.now();
        System.out.println(" ");
        System.out.println(dupa);
        int diferenta = (int) ChronoUnit.MILLIS.between(acum, dupa);
        System.out.println("Nr de milisecunde in care s-a executat quickSortul : " + diferenta);
    }

    private static void insertionSort() {
        LocalTime acum = LocalTime.now();
        System.out.println(acum);

        int[] myArray = {9, 8, 7, 6, 5, 5, 4, 3, 2, 1};
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println(" ");
//        InsertionSort.sort(myArray);
        InsertionSort.insertionSort(myArray);

        LocalTime dupa = LocalTime.now();
        System.out.println(" ");
        System.out.println(dupa);
        int diferenta = (int) ChronoUnit.MILLIS.between(acum, dupa);
        System.out.println("Nr de milisecunde in care s-a executat insertionSortul : " + diferenta);
    }

    private static void mergeSort() {
        LocalTime acum = LocalTime.now();
        System.out.println(acum);

        int[] myArray = {10, 30, 3, 8, 9, 18, 9, 25};
        MergeSort.printArray(myArray);

        int[] arraySortat = MergeSort.sort(myArray);
        //Daca ii dai void in loc de int[] la sort poti sa scrii
        //MergeSort.sort(myArray) si myArray isi ia automat valoarea sortata
        //ca atunci cand ii dai print (dupa ce ii dai sort) se va scrie myArray sortat
//        MergeSort.printArray(arraySortat);

        LocalTime dupa = LocalTime.now();
        System.out.println(" ");
        System.out.println(dupa);
        int diferenta = (int) ChronoUnit.MILLIS.between(acum, dupa);
        System.out.println("Nr de milisecunde in care s-a executat mergeSortul : " + diferenta);
    }

    private static void bubbleSort() {
        LocalTime acum = LocalTime.now();
        System.out.println(acum);

        int[] array = {2, 4, 3};
        int[] myArray = {6, 5, 3, 1, 8, 7, 2, 4};
//        Scanner s = new Scanner(System.in);
//        System.out.println("Introduceti elementele: ");
        int n = 10;


        //Random java util (ca scannerul)
        Random random = new Random();

        //Initializezi si parcurgi array-ul
        int[] nrRandom = new int[n];
        for (int i = 0; i < nrRandom.length; i++) {
            int numberRandom = random.nextInt(10);
            nrRandom[i] = numberRandom;
        }

        BubbleSort mySort = new BubbleSort(array);
        BubbleSort mySort2 = new BubbleSort(myArray);
        BubbleSort mySort3 = new BubbleSort(nrRandom);
        mySort.startSort();
        mySort2.startSort();
        mySort3.startSort();

        LocalTime dupa = LocalTime.now();
        System.out.println(" ");
        System.out.println(dupa);
        int diferenta = (int) ChronoUnit.MILLIS.between(acum, dupa);
        System.out.println("Nr de milisecunde in care s-a executat bublleSortul : " + diferenta);
    }
}
