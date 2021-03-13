package com.dzk.search;

/**
 * 查找区间
 *  Find First and Last Position of Element in Sorted Array
 *  Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 *
 * 题目描述：给定一个有序数组 nums 和一个目标 target，要求找到 target 在 nums 中的第一个位置和最后一个位置。
 *
 * 可以用二分查找找出第一个位置和最后一个位置，但是寻找的方法有所不同，需要实现两个二分查找。我们将寻找 target 最后一个位置，转换成寻找 target+1 第一个位置，再往前移动一个位置。这样我们只需要实现一个二分查找代码即可。
 */
public class FindRange {
    public static void main(String[] args) {
        int[] input = {5,7,7,8,8,8,10};
        int[] result = searchRange(input, 8);
        System.out.println("["+result[0]+","+result[1]+"]");
    }
    private static int[] searchRange(int[] input,int target){
        int firstIndex = findFirst(input,target);
        int lastIndex = findFirst(input,target + 1) -1;
        if (firstIndex == -1 || firstIndex == input.length || input[firstIndex] != target){
            return new int[]{-1,-1};
        }else {
            return new int[]{firstIndex,Math.max(firstIndex,lastIndex)};
        }
    }

    private static int findFirst(int[] input, int target) {
        if (input == null || input.length == 0){
            return -1;
        }
        int l = 0;
        int h = input.length-1;
        int mid= 0;
        while (l < h){
            mid = l + (h -l) / 2;
            if (input[mid] >= target){
                h = mid;
            }else {
                l = mid +1;
            }
        }
        return l;
    }
}
