package com.dzk.double_pointer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出所有和为 S 的连续正数序列。例如和为 100 的连续序列有：
 * [9, 10, 11, 12, 13, 14, 15, 16]
 * [18, 19, 20, 21, 22]。
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        List<List<Integer>> continuousSequence = findContinuousSequence(100);
        System.out.println(continuousSequence);
    }

    /**
     * start与end从1,2开始计算，逐渐比较与扩大范围，直到end = target时停止
     * @param target
     * @return
     */
    private static List<List<Integer>> findContinuousSequence(int target){
        List<List<Integer>> ret = new ArrayList<>();
        int start = 1;
        int end = 2;
        int curSum = 3;
        while (end < target){
            if (curSum < target){
                end++;
                curSum += end;
            }else if (curSum > target){
                curSum -= start;
                start++;
            }else {
                List<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                ret.add(list);
                end++;
                curSum += end;
            }
        }
        return ret;
    }
}
