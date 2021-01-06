package com.dzk.sort;

public class BaseSort {
    protected static void printArray(int[] input) {
        if (input != null && input.length > 0){
            for (int value : input) {
                System.out.print(" "+ value);
            }
        }
    }

    //交换
    protected static void swap(int[] input, int i, int min) {
        int temp = input[i];
        input[i] = input[min];
        input[min] = temp;
    }
}
