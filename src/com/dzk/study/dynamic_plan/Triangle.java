package com.dzk.study.dynamic_plan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数字组成的三角形，求从顶部到底部所有路径中最小的和
 *           1
 *         2   3
 *        4  5  6
 *       7  8  9 10
 */
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> first =  Arrays.asList(1);
        List<Integer> second = Arrays.asList(2,3);
        List<Integer> third = Arrays.asList(4,5,6);
        List<Integer> four = Arrays.asList(7,8,9,10);
        nums.add(first);
        nums.add(second);
        nums.add(third);
        nums.add(four);
        System.out.println(calcMiniPath(nums));
    }

    private static int calcMiniPath(List<List<Integer>> nums){
        if (nums == null || nums.size() == 0) return 0;
        int rows = nums.size();
        int[] res = new int[rows + 1];
        for (int i = rows - 1; i >= 0;i--){
            for (int j = 0; j <= i; j++) {
                res[j] = Math.min(res[j],res[j + 1]) + nums.get(i).get(j);
            }
        }
        return res[0];
    }
}
