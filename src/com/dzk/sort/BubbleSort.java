package com.dzk.sort;

/**
 * 冒泡排序:数组中，从左到右依次交换逆序的相邻元素，一轮交换过后，数组最大的元素上浮到数组的右侧。
 * 在一轮循环中如果没有发生交换，表面数组已经排好序
 */
public class BubbleSort extends BaseSort{
    public static void main(String[] args) {
        int[] input = {3,2,4,1,6,-1};
//        int[] input = {-1,2,3,4,5,6};
        doSort(input);
        printArray(input);
    }

    //冒泡排序
    private static void doSort(int[] input) {
        if (input == null ||input.length < 2){
            return;
        }
        boolean isSorted = false;
        for (int i = 0; i < input.length-1; i++) {
            isSorted = false;
            for (int j = 0; j < input.length - 1 - i; j++) {
                if (input[j] > input[j+1]){
                    swap(input,j,j+1);
                    isSorted = true;
                }
            }

            if (!isSorted){
                System.out.println("没有一次交换,已经排好序");
                return;
            }
        }
    }
}
