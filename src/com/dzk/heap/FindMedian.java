package com.dzk.heap;

import java.util.PriorityQueue;

/**
 * 查找中位数
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class FindMedian {
    //大根堆，存储左半边元素
    private static PriorityQueue<Integer> left = new PriorityQueue<>(((o1, o2) -> o2-o1));
    //小根堆，存储右半边元素，并且右半边元素均大于左半边元素
    private static PriorityQueue<Integer> right = new PriorityQueue<>();
    //当前元素的个数
    private static int N = 0;
    public static void main(String[] args) {
            insert(1);
            insert(2);
            insert(3);
//            insert(4);
        System.out.println(getMedian());
    }

    /**
     * 插入时为了左右堆均衡，实现奇偶数区分添加，保持左侧最大堆小于右侧最小堆
     * @param val
     */
    private static void insert(int val){
        /**
         * N为偶数的情况下，插入到右边，但是新插入的元素不一定比左边大，因此，先添加到左边，然后添加到右边
         */
        if (N % 2 == 0){
            left.add(val);
            right.add(left.poll());
        }else {
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }

    private static double getMedian(){
        if (N % 2 == 0){
            return (left.peek() + right.peek()) / 2.0;
        }else {
            return (double)right.peek();
        }
    }
}
