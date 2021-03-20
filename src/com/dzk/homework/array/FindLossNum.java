package com.dzk.homework.array;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入: [0,1,3]
 * 输出: 2
 */
public class FindLossNum {
    public static void main(String[] args) {
        int[] input = {0,1,3};
        int result = findLoss(input);
        System.out.println(result);
    }

    /**
     * 比较下标和对应下标的值是否一致
     * @param input
     * @return
     */
    private static int findLoss(int[] input) {
        int length = input.length;
        for (int i = 0; i < length; i++) {
            if (i != input[i]){
                return input[i] - 1;
            }
        }
        return input[length - 1] + 1;
    }

    private static int findLossByHalf(int[] input){
        int lo = 0;
        int hi = input.length - 1;
        while (lo < hi){
            int mid = lo + (hi -lo) / 2;
            if (mid == input[mid]){
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }
        if (hi == input[hi]){
            return input[hi] + 1;
        }else {
            return input[hi] - 1;
        }
    }
}
