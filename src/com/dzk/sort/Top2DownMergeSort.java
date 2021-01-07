package com.dzk.sort;

/**
 * 归并排序  归并排序的思想是将数组分成两部分，分别进行排序，然后归并起来。
 * 自上而下归并排序
 */
public class Top2DownMergeSort extends BaseSort{
    private static int[] temp;
    public static void main(String[] args) {
        int[] input = {3,2,4,1,6,-1};
        temp = new int[input.length];
        doSort(input);
        printArray(input);
    }

    private static void doSort(int[] input) {
        if (input == null || input.length < 2){
            return;
        }
        sort(input,0,input.length - 1);
    }

    //归并
    private static void merge(int[] input,int left,int middle,int right){
        int p = left;
        int q = middle + 1;
        //复制数组数据，放入临时数组
        for (int i = left; i <= right; i++) {
            temp[i] = input[i];
        }

        for (int k = left; k <= right; k++) {
            if (p > middle){
                input[k] = temp[q++];
            }else if (q > right){
                input[k] = temp[p++];
            }else if (temp[p] <= temp[q]){//这里比较的是temp，不是input，一不小心就写成input了，切记！切记！
                input[k] = temp[p++];
            }else {
                input[k] = temp[q++];
            }
        }
    }

    /**
     * 自顶而下分组归并
     */
    private static void sort(int[] input, int left, int right){
        if (left >= right){//只有一个元素，无需排序
            return;
        }

        int middle = left + (right - left) / 2;
        sort(input, left, middle);
        sort(input, middle + 1, right);
        merge(input,left,middle,right);
    }
}
