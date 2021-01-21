package com.dzk.search;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] input = {1,2,2,3,4,5,6};
//        int position = binarySearch(input,6);
        int position = binarySearchFirstAppearPosition(input,2);
        System.out.println(position);
    }

    private static int binarySearch(int[] input,int key) {
        if (input == null ||input.length == 0){
            return -1;
        }

        int left = 0;
        int right = input.length - 1;
        while (left <= right){
            int middle = left + (right - left) / 2;
            if (key == input[middle]){
                return middle;
            }else if (key < input[middle]){
                right = middle - 1;
            }else {
                left  = middle + 1;
            }
        }
        return -1;
    }

    // TODO 二分查找变体,针对有序序列中有重复元素的序列，返回第一次出现的位置,注意边界值while循环条件，如果l<=h，会引起死循环
    private static int binarySearchFirstAppearPosition(int[] input,int key) {
        if (input == null ||input.length == 0){
            return -1;
        }

        int l = 0;
        int h = input.length - 1;
        while (l < h){
            int m = l + (h - l) / 2;
            if (input[m] >= key){
                h = m;
            }else {
                l = m + 1;
            }
        }
        if (input[l] == key){
            return l;
        }
        return -1;
    }

}
