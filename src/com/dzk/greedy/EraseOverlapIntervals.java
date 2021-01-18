package com.dzk.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目描述:计算让一组区间不重叠所需要移除的区间个数。
 * 满足不重叠区间，需要移除重复区间的个数
 * Input: [ [1,2], [1,2], [1,2] ]
 *
 * Output: 2
 *
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 *
 * 题解思想:先计算出不重复区间的最大个数，总的区间数-不重复区间的个数，就是需要移除的重复区间个数。
 *
 */
public class EraseOverlapIntervals {

    public static void main(String[] args) {
        int[][] interval = {{1,2},{1,3},{2,3}};
        int result = eraseOverlapIntervals(interval);
        System.out.println(result);
    }

    private static int eraseOverlapIntervals(int[][] interval) {
        if (interval == null ||interval.length < 2){
            return 0;
        }
        Arrays.sort(interval, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] < o2[1] ? -1:o1[1] == o2[1] ? 0: 1;
            }
        });
        int count =1;
        int end = interval[0][1];

        for (int i = 1; i < interval.length; i++) {
            if (interval[i][0] < end){
                continue;
            }

            count++;
            end = interval[i][1];
        }

        return interval.length - count;
    }


}
