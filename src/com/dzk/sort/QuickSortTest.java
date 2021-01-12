package com.dzk.sort;

public class QuickSortTest extends BaseSort{
    public static void main(String[] args) {
        int[] input=  {2,3,1,4,5,9,1};
        sort(input,0,input.length - 1);
        printArray(input);
    }

    private static void sort(int[] input, int left, int right) {
        if (left >= right){
            return;
        }

        int devide =partion(input,left,right);
        sort(input, left, devide - 1);
        sort(input, devide + 1, right);
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
            swap(input, lo, hi);
        }
        swap(input,left,hi);
        return hi;
    }
}
