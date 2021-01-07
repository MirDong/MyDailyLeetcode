package com.dzk.sort;

public class Down2TopMergeSort extends BaseSort {
    private static int[] temp;//辅助空间

    public static void main(String[] args) {
        int[] input = {3, 2, 4, 1, 6, -1};
        temp = new int[input.length];
        doSort(input);
        printArray(input);
    }

    private static void doSort(int[] input) {
        if (input == null || input.length < 2) {
            return;
        }
        sort(input);
    }

    //归并
    private static void merge(int[] input, int left, int middle, int right) {
        int p = left;
        int q = middle + 1;
        //复制数组数据，放入临时数组
        for (int i = left; i <= right; i++) {
            temp[i] = input[i];
        }

        for (int k = left; k <= right; k++) {
            if (p > middle) {
                input[k] = temp[q++];
            } else if (q > right) {
                input[k] = temp[p++];
            } else if (temp[p] <= temp[q]) {//这里比较的是temp，不是input，一不小心就写成input了，切记！切记！
                input[k] = temp[p++];
            } else {
                input[k] = temp[q++];
            }
        }
    }

    /**
     * 自顶而下分组归并
     */
    private static void sort(int[] input) {
        int N = input.length;
        for (int sz = 1; sz < N; sz = sz + sz) {// sz子数组大小
            for (int low = 0; low < N - sz; low += sz + sz) {// low: 子数组索引
                merge(input, low, low + sz - 1, Math.min(low + sz + sz - 1, N - 1));
            }
        }
    }
}
