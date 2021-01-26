package com.dzk.search;

import java.util.BitSet;

/**
 * 有序数组的 Single Element
 * 题目描述：一个有序数组只有一个数不出现两次，找出这个数
 * Input: [1, 1, 2, 3, 3, 4, 4, 8, 8]
 * Output: 2
 *
 * 要求以 O(logN) 时间复杂度进行求解，因此不能遍历数组并进行异或操作来求解，这么做的时间复杂度为 O(N)。
 */
public class SingleElementInSortedArray {
    public static void main(String[] args) {
       int[] input =  {1, 1, 2, 3, 3, 4, 4, 8, 8};
//        int target = findSingleElementWithBitSet(input);
        int target = singleNonDuplicate(input);
        System.out.println(target);
    }

    /**
     * 使用bitset的方式求解，时间复杂度为O(n),如果要求时间复杂度为O(logN)，该方法不适用
     * @param input
     * @return
     */
    private static int findSingleElementWithBitSet(int[] input) {
        if (input == null || input.length == 0){
            throw new NullPointerException("input is null or empty");
        }
        int length = input.length;
        BitSet bitSet = new BitSet(length);
        BitSet bitSet2 = new BitSet(length);
        for (int i = 0; i < input.length; i++) {
            if (!bitSet.get(input[i]) && !bitSet2.get(input[i])){
                bitSet.set(input[i]);
            }else if (bitSet.get(input[i]) && !bitSet2.get(input[i])){
                bitSet2.set(input[i]);
            }
        }

        for (int i = 0; i < length; i++) {
            if (bitSet.get(input[i]) && !bitSet2.get(input[i])){
                return input[i];
            }
        }
        return 0;
    }


    /**
     * 令 index 为 Single Element 在数组中的位置。在 index 之后，数组中原来存在的成对状态被改变。如果 m 为偶数，并且 m + 1 < index，那么 nums[m] == nums[m + 1]；m + 1 >= index，那么 nums[m] != nums[m + 1]。
     *
     * 从上面的规律可以知道，如果 nums[m] == nums[m + 1]，那么 index 所在的数组位置为 [m + 2, h]，此时令 l = m + 2；如果 nums[m] != nums[m + 1]，那么 index 所在的数组位置为 [l, m]，此时令 h = m。
     *
     * 因为 h 的赋值表达式为 h = m，那么循环条件也就只能使用 l < h 这种形式
     * @param nums
     * @return
     */
    public static int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
       while (l < h){
           int m = l + (h - l) / 2;
           if (m % 2 == 1){
               m--;
           }

           if (nums[m] == nums[m +1]){
               l = m + 2;
           }else {
               h = m;
           }
       }
       return nums[l];
    }
}
