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
//        List<Integer> minHeap = getLeastKHeap(input, 4);
        List<Integer> minHeap = getMinKScopeList(input, 4);
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

    //方法二  快速选择，  通过快速排序算法，找到第K个元素，此时第K个元素左边的元素均小于第K个元素
    private static List<Integer> getMinKScopeList(int[] input,int k){
        List<Integer> res = new ArrayList<>();
        if (input.length < k || k < 0){
            return res;
        }

        findKthCollections(input,k);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }
    /*public void findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k)
                break;
            if (j > k)
                h = j - 1;
            else
                l = j + 1;
        }
    }*/
    private static void findKthCollections(int[] input, int k) {
        int length = input.length - 1;
        int l = 0;
        int h = length;
        while (l < h){
            int j = partion(input,l,h);
            if (k == j){
                break;
            }else if (k > j){
                l = j + 1;
            }else {
                h = j - 1;
            }
        }
    }
/*    private int partition(int[] nums, int l, int h) {
        int p = nums[l];     *//* 切分元素 *//*
        int i = l, j = h + 1;
        while (true) {
            while (i != h && nums[++i] < p) ;
            while (j != l && nums[--j] > p) ;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }*/
    private static int partion(int[] input, int l, int h) {
        int element = input[l];
        int left = l;
        int right = h + 1;
        while (true){
            while (left != h && input[++left] < element);
            while (right != l && input[--right] > element);
            if (left >= right){
                break;
            }
            wrap(input,left,right);
        }
        wrap(input,right,l);
        return right;
    }

    private static void wrap(int[] input, int right, int l) {
        int temp = input[right];
        input[right] = input[l];
        input[l] = temp;
    }









}
