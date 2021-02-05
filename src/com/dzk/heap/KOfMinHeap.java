package com.dzk.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 最小的K个数
 * 利用了最大堆与最小堆的思想
 */
public class KOfMinHeap {
    public static void main(String[] args) {
        int[] input = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        List<Integer> minHeap = getLeastKHeap(input, 4);
        System.out.println(minHeap);
    }

    /**
     * # 大小为 K 的最小堆
     *  •复杂度：O(NlogK) + O(K)
     *  •特别适合处理海量数据
     *
     * 维护一个大小为 K 的最小堆过程如下：使用大顶堆。在添加一个元素之后，如果大顶堆的大小大于 K，那么将大顶堆的堆顶元素去除，也就是将当前堆中值最大的元素去除，从而使得留在堆中的元素都比被去除的元素来得小。
     *
     * 应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
     *
     * Java 的 PriorityQueue 实现了堆的能力，PriorityQueue 默认是小顶堆，可以在在初始化时使用 Lambda 表达式 (o1, o2) -> o2 - o1 来实现大顶堆。其它语言也有类似的堆数据结构。
     * @param input
     * @param K
     * @return
     */
    private static List<Integer> getLeastKHeap(int[] input,int K){
        if (input.length < K || K < 0){
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < input.length; i++) {
            maxHeap.add(input[i]);
            while (maxHeap.size() > K){
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }
}
