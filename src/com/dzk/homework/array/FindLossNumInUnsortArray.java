package com.dzk.homework.array;

import java.util.BitSet;

/**
 * 在一个长度为n的数组内，元素值的范围为0-n,里面缺失了一个元素，请找出这个元素
 */
public class FindLossNumInUnsortArray {

    public static void main(String[] args) {
        int[] nums = {2,4,1,5,0,6};
        int res = findLossNum(nums);
        System.out.println(res);
    }

    private static int findLossNum(int[] nums){
        if (nums == null || nums.length == 0) return -1;
        BitSet bitSet = new BitSet(nums.length + 1);
        for (int i = 0; i < nums.length; i++) {
            bitSet.set(nums[i]);
        }
        int target = -1;
        for (int i = 0; i < bitSet.length(); i++) {
            if (!bitSet.get(i)){
                target = i;
            }
        }
        return target;
    }
}
