package com.dzk.sort;



/**
 * 选择排序,从数组中选择最小的元素与第一个元素交换，然后在剩余的数组中选择最小的元素与第二个元素交换，依次重复，直至排序完成
 */
public class ChooseSort extends BaseSort{
    public static void main(String[] args) {
        int[] input = {3,2,4,1,6,-1};
        doSort(input);
        printArray(input);
    }


    //快速排序
    private static void doSort(int[] input) {
        if (input == null || input.length < 2){
            return;
        }
        int length = input.length;
        int min = 0;
        for (int i = 0; i < length-1; i++) {
            min = i;
            //出错点:j从i+1开始，因为i之前的已经是有序的
            for (int j = i + 1; j < length; j++) {
                if (input[j] < input[min]){
                    min = j;
                }
            }
            if (min != i){
                swap(input,i,min);
            }
        }
    }
}
