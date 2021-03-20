package com.dzk.homework.array;

/**
 * 移动零
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] nums = {1,2,0,3,0,4};
        moveZero(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }


    private static void moveZero(int[] nums){
        if (nums == null || nums.length == 0) return;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++){
            if (nums[fast] != 0){
                if (slow != fast){
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                }
                slow++;
            }
        }
    }



    private void moveZero2(int[] nums){
        if (nums == null || nums.length == 0) return;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++){
            if (nums[fast] != 0){
                if(slow != fast){
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                }
                slow++;
            }
        }
    }
}
