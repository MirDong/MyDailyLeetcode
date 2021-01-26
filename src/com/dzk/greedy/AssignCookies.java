package com.dzk.greedy;

import java.util.Arrays;

/**
 * 贪心算法:
 * 分配饼干，每个孩子都有一个满足度 grid，每个饼干都有一个大小 size，只有饼干的大小大于等于一个孩子的满足度，该孩子才会获得满足。求解最多可以获得满足的孩子数量。
 * 贪心思想:保证每次操作都是局部最优的，并且最后得到的结果是全局最优的。
 * #1. 分配饼干
 * 解题思路:
 * 1.给一个孩子的饼干，既要尽量小又能满足孩子，剩余的大饼干可以满足更大满足度的孩子
 * 2.因为满足度小的孩子最容易满足，先分配满足度小的孩子
 */
public class AssignCookies {
    public static void main(String[] args) {
        int[] grid = {1,3};
        int[] size = {1,2,4};
        int childCount = assignCookies(grid,size);
        System.out.println("可以满足的孩子数量: " + childCount);
    }

    private static int assignCookies(int[] grid, int[] size) {
        if (grid == null || size == null){
            return 0;
        }

        Arrays.sort(grid);
        Arrays.sort(size);
        int gridIndex = 0;
        int sizeIndex = 0;
        while (gridIndex <= grid.length - 1 && sizeIndex <= size.length - 1){
            if (grid[gridIndex] <= size[sizeIndex]){
                gridIndex++;
            }
            sizeIndex++;
        }
        return gridIndex;
    }

}
