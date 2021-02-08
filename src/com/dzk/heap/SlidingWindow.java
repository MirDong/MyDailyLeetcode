package com.dzk.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 滑动窗口
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *
 * 例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，那么一共存在 6 个滑动窗口，他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 * 解题思路:维护一个大小为窗口大小的大顶堆，顶堆元素则为当前窗口的最大值。
 *
 * 假设窗口的大小为 M，数组的长度为 N。在窗口向右移动时，需要先在堆中删除离开窗口的元素，并将新到达的元素添加到堆中，这两个操作的时间复杂度都为 log2M，因此算法的时间复杂度为 O(Nlog2M)，空间复杂度为 O(M)。
 */
public class SlidingWindow {
    public static void main(String[] args) {
        int[] input = {2,3,4,2,6,2,5,1};
        int size = 3;//滑动窗口大小
        List<Integer> maxList = maxInWindow(input,size);
        System.out.println(maxList);
    }

    private static List<Integer> maxInWindow(int[] input, int size) {
        List<Integer> ret = new ArrayList<>();
        if (size > input.length || size < 1){
            return ret;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 -o1));
        for (int i = 0; i < size; i++) {
            queue.add(input[i]);
        }
        ret.add(queue.peek());
        for (int j = 0,k = j + size; k < input.length; k++,j++){
            queue.remove(input[j]);
            queue.add(input[k]);
            ret.add(queue.peek());
        }
        return ret;
    }
}
