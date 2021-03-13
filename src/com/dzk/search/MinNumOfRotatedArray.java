package com.dzk.search;

/**
 * 旋转数组的最小数字   1->2->3->4->5->1...
 * Input: [3,4,5,1,2],
 * Output: 1
 */
public class MinNumOfRotatedArray {

    public static void main(String[] args) {
        int[] input = {3,4,5,6,1,2};
        int index = findMinNumber(input,0,input.length - 1);
        System.out.println(index);
    }

    /**
     * 比较
     * @param input
     * @param start
     * @param end
     * @return
     */
    private static int findMinNumber(int[] input,int start,int end) {
        if (input == null ||input.length == 0){
            return -1;
        }
        int l = start;
        int h = end;
        int mid;
        while (l < h){
            mid = l + (h -l)/2;
            if (input[mid] > input[h]){
                l = mid + 1;
            }else {
                h = mid;
            }
        }
        return input[l];
    }
}
