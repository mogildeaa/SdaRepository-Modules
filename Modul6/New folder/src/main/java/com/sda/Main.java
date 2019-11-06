package com.sda;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        for (int i = 1; i <= 100; i++) {
//            if (i % 5 == 0 && i % 3 == 0) {
//                System.out.println(("FizzBuz"));
//            } else if (i % 5 == 0) {
//                System.out.println(("Buzz"));
//            } else if (i % 3 == 0) {
//                System.out.println("Fizz");
//            } else {
//                System.out.println((i));
//            }
//        }
//        int[] array = {1, 2, 3, 5, 4};
//        System.out.println(searchNumber(array, 5));
//
//        Arrays.binarySearch(array, 5);

        int[] myArray = new int[]{10,20,30,40,50};
        int[] myArray5 = new int[]{10,20,30,40,50,6,7,8,9};
        int[] myArray2 = new int[]{10,20,30,40,10};
        int[] myArray4 = new int[]{1,2,3,4,90,90};
        int[] myArray3 = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDupplicate(myArray));
        System.out.println(containsDupplicate(myArray2));
        System.out.println(containsDupplicate(myArray3));
        System.out.println(containsDupplicate(myArray4));
        System.out.println(containsDupplicate(myArray5));
    }

    static boolean containsDupplicate(int[] arr){
        boolean dupplicate = false;
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                if(arr[i] == arr[j] && i != j){
                    count++;
                }
            }

            if(count != 0){
                dupplicate = true;
                break;
            }
        }
        return dupplicate;
    }

    static int searchNumber(int[] v, int target) {

        int left = 0;
        int right = v.length - 1;
        int mid = -1;

        while (left <= right) {
            mid = left/2 + right/2;
            if (v[mid] == target) {
                return mid;
            } else if (v[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return mid;
    }

    static int binarySearch(int[] nums, int target){
        return searchR(nums ,target, 0, nums.length -1);
    }

    static int searchR(int nums[], int target, int left, int right){
        int mid = left/2 + right/2;

        if(left<=right){
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                return searchR(nums, target, mid+1, right);
            } else {
                return searchR(nums, target, left, mid-1);
            }
        }
        return -1;
    }
}
