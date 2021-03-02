package com.dzk.array;

/**
 * 题目描述:在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 要求时间复杂度 O(N)，空间复杂度 O(1)
 * Input:
 * {2, 3, 1, 0, 2, 5}
 *
 * Output:
 * 2
 *
 * 解题思路:在原数组中查找重复数字，不能使用标记数组和排序。由于数组元素在0~n-1,因此考虑到在数组中每个元素对应下标摆放，观察有没有同一个下标中元素重复的现象
 */
public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] input = {2, 3, 1, 0, 2, 5};
        int[] output = new int[1];
        boolean hasDuplicate = findDuplicate(input,input.length,output);
        String value = hasDuplicate ?",重复数字是:" + output[0] : "";
        System.out.println("是否有重复数字: "+hasDuplicate + value);
    }

    private static boolean findDuplicate(int[] input,int length,int[] output){
        if (input == null || length == 0){
            return false;
        }

        for (int i = 0; i < length; i++) {
            while (i != input[i]){
                if (input[i] == input[input[i]]){
                    if (output == null || output.length == 0){
                        throw new IllegalArgumentException("output array must be not null and length > 0");
                    }
                    output[0] = input[i];
                    return true;
                }
                swap(input,i,input[i]);
            }
        }
        return false;
    }

    private static void swap(int[] input, int source, int target) {
        int temp = input[source];
        input[source] = input[target];
        input[target] = temp;
    }
}
