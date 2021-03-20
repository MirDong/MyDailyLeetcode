package com.dzk.homework.array;

import java.util.Stack;

/**
 * 如何在未排序整数数组中找到最大值和最小值?字节跳动
 */
public class FindMaxAndMin {
    public static void main(String[] args) {
        int[] nums = {3,5,2,6,7,9,12,13,4,5,1,0};
        int[] maxAndMin = getMaxAndMin(nums);
        System.out.println("max = "+maxAndMin[0]+",min = " + maxAndMin[1]);
    }

    /**
     * 依次遍历，通过堆栈压入弹出的方式
     * @param nums
     * @return
     */
    private static int[] getMaxAndMin(int[] nums){
        int[] result = new int[2];
        if (nums == null) return nums;
        Stack<Integer> maxStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (!maxStack.isEmpty() && maxStack.peek() < nums[i]) {
                maxStack.pop();
                maxStack.push(nums[i]);
            }else if (maxStack.isEmpty()){
                maxStack.push(nums[i]);
            }

            if (!minStack.isEmpty() && minStack.peek() > nums[i]) {
                minStack.pop();
                minStack.push(nums[i]);
            }else if (minStack.isEmpty()){
                minStack.push(nums[i]);
            }
        }
        result[0] = maxStack.pop();
        result[1] = minStack.pop();
        return result;
    }
}
