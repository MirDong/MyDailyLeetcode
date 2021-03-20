package com.dzk.homework.array;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 限制  2 <= n <= 100000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDumplicateNumber {
    public static void main(String[] args) {

    }

    /**
     * 方法一   创建一个新数组记录每个数字出现的次数。以元素为下标，次数为数组的值
     * @param nums
     * @return
     */
    private static int findRepeatedNumber(int[] nums){
        int length = nums.length;
        int[] newArray = new int[length];
        for (int i = 0; i < length; i++) {
            newArray[nums[i]]++;
        }

        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] > 1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 将数组内元素按照下标与值对齐的方式，遍历数组，如果其中元素和某一个下标中的值刚好一样，就返回
     * @param nums
     * @return
     */
    private static int findRepeatedNumberInArray(int[] nums){
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (i != nums[i]){
                if (nums[i] != nums[nums[i]]){
                    swap(nums,i,nums[i]);
                }else {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
