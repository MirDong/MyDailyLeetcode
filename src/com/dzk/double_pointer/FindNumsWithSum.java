package com.dzk.double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在有序数组中找出两个数，使得和为给定的数 S。如果有多对数字的和等于 S，输出两个数的乘积最小的。
 * 解题思路：利用双指针，分别从有序数组的头部和尾部进行进行遍历，如果两指针指向的元素之和大于S，则尾部指针左移，两指针指向的元素之和小于S，
 * 则指针右移，相等则直接返回。
 */
public class FindNumsWithSum {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};
        List<Integer> list = findNumsWithSum(input,5);
        System.out.println(list);
    }

    private static List<Integer> findNumsWithSum(int[] input,int target){
        List<Integer> res = new ArrayList<>();
        if (input == null ||input.length == 0){
            return res;
        }

        int left = 0;
        int right = input.length - 1;
        while (left < right){
            if (input[left] + input[right] == target){
                return Arrays.asList(input[left],input[right]);
            }else if (input[left] + input[right] > target){
                right--;
            }else {
                left++;
            }
        }
        return res;
    }
}
