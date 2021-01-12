package com.dzk.sort;

public class QuickSort extends BaseSort{

    public static void main(String[] args) {
//        int[] input = {3,2,4,1,6,-1};
        int[] input = {6,3,2,4,1,-1};
        printArray(input);
        System.out.println();
        doSort(input,0,input.length -1);
        printArray(input);
    }

    private static void doSort(int[] input,int left,int right) {
        if (left >= right){
            return;
        }
        int devider = partion(input,left,right);
        doSort(input, left, devider - 1);
        doSort(input, devider + 1,right);
    }

    private static int partion(int[] input, int left, int right) {
        int lo = left;
        int hi = right + 1;
        int refer = input[left];
        while (true){
            while (input[++lo] < refer && lo != right);
            while (input[--hi] > refer && hi != left);
            if (lo >= hi){
                break;
            }
            swap(input,lo,hi);
        }

        swap(input,left,hi);
        return hi;
    }
}
