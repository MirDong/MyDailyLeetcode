package com.dzk.study;

import java.util.*;

/**
 * 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于[n/2]的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 输入：[3,2,3]
 * 输出：3
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyMajority {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2};
//        int major = majorityElement(nums);
        int major = majorityElementByMap(nums);
        System.out.println(major);
    }

    /**
     *
     * @param nums
     * @return
     */
    private static int majorityElement(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    private static int majorityElementByMap(int[] nums){
        if (nums == null || nums.length == 0) return -1;
        Map<Integer,Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(nums[i])){
                Integer count =  maps.get(nums[i]);
                maps.put(nums[i],++count);
                if (count > nums.length / 2){
                    return nums[i];
                }
            }else {
                maps.put(nums[i], 1);
            }
        }
        return -1;
    }

    /**
     * Boyer-Moore投票算法，设置count = 0，遇到众数+1，非众数-1，由于众数是多于非众数的，所以count为非负数且大于0
     * @param nums
     * @return
     */
    private static int majorityElementByBoyer(int[] nums){
        Integer candidate = null;
        int count = 0;
        for (int num:nums){
            if (count == 0){
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }
}
