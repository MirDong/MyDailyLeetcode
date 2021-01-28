package com.dzk.search;

/**
 * 旋转数组的最小数字
 *
 */
public class FindMinInRotate {
    public static void main(String[] args) {
       int[] input = {3,4,5,1,2};
        int min = findMin(input);
        System.out.println("min值: "+ min);

    }

    private static int findMin(int[] input) {
        if (input == null){
            throw new NullPointerException("input array is null");
        }


        int left = 0;
        int right = input.length - 1;
        while (left < right){
            int middle = left + (right - left) / 2;
            if (input[middle] <= input[right]){
                right = middle;
            }else {
                left = middle + 1;
            }
        }
        return input[left];
    }
}
