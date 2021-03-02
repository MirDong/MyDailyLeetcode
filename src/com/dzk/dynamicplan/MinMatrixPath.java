package com.dzk.dynamicplan;

/**
 * [[1,3,1],
 *  [1,5,1],
 *  [4,2,1]]
 * Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 * 题目描述：求从矩阵的左上角到右下角的最小路径和，每次只能向右和向下移动。
 */
public class MinMatrixPath {
    public static void main(String[] args) {
        int[][] input = {{1,3,1},{1,5,1},{4,2,1}};
        int sum = minPathSum(input);
        System.out.println(sum);
    }

    private static int minPathSum(int[][] matrix){
        if (matrix == null ||matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0){//从上侧走到该位置
                    dp[j] = dp[j];
                }else if (i == 0){//从左侧走到该位置
                    dp[j] = dp[j - 1];
                }else {
                    dp[j] = Math.min(dp[j],dp[j - 1]);
                }
                dp[j] += matrix[i][j];
            }
        }
        return dp[n - 1];
    }
}
