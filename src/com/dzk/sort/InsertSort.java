package com.dzk.sort;

/**
 * 插入排序，每次都将当前元素插入到左侧已排序的数组中，插入后依然有序
 */
public class InsertSort extends BaseSort{
    public static void main(String[] args) {
        int[] input = {3,2,4,1,6,-1};
        doSort(input);
        printArray(input);
    }

    private static void doSort(int[] input) {
        if (input == null || input.length < 2){
            return;
        }

        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j-1] > input[j]){
                    swap(input,j-1,j);
                }else {
                    break;
                }
            }
        }
    }
}
