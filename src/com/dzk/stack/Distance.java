package com.dzk.stack;

import java.util.Stack;

/**
 * 数组中元素与下一个比它大的元素之间的距离
 * 在遍历数组时用栈把数组中的数存起来，如果当前遍历的数比栈顶元素来的大，说明栈顶元素的下一个比它大的数就是当前元素。
 */
public class Distance {
    public static void main(String[] args) {
        int[] input = {73,74,75,71,69,72,76,73};
        int[] out = dailyTemperatures(input);
        for (int num:out){
            System.out.print(num + ",");
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] dist = new int[n];
        Stack<Integer> indexs = new Stack<>();
        for (int curIndex = 0; curIndex < n; curIndex++) {
            while (!indexs.isEmpty() && temperatures[curIndex] > temperatures[indexs.peek()]) {
                int preIndex = indexs.pop();
                dist[preIndex] = curIndex - preIndex;
            }
            indexs.add(curIndex);
        }
        return dist;
    }
}
