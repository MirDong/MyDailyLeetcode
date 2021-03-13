package com.dzk.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个数组nums和一个整数目标值target,请您在该数组中找到和为目标值的两个整数，并返回他们的数组下标
 * 假设可以每种输入只对应一个答案，但是，数组中同一个元素不能使用两遍
 * 输入：nums=[2,7,11,15],target=9
 * 输出:[0,1]
 */
public class TwoNumberSum {
    public static void main(String[] args) {
        int[] input = {2,7,11,15};
        int[] indexOfNumbers = findIndexOfNumbers(input, 9);
        for (int index : indexOfNumbers) {
            System.out.println(index);
        }
    }

    /**
     * 使用target-i，查找集合中是否有target-i元素，如果有，返回两个元素下标，否则，返回空数组
     * @param input
     * @param target
     */
    private static int[] findIndexOfNumbers(int[] input, int target) {
        if (input == null || input.length == 0){
            return new int[0];
        }
        Map<Integer,Integer> maps = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (!maps.isEmpty() && maps.containsKey(target -input[i])){
                return new int[]{i,maps.get(target-input[i])};
            }
            maps.put(input[i],i);
        }
        return new int[0];
    }
}
