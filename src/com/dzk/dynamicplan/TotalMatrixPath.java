package com.dzk.dynamicplan;

import java.util.Arrays;

public class TotalMatrixPath {
    public static void main(String[] args) {

    }

    private static int updateUnique(int[][] matrix){
         if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
             return 0;
         }
         int m = matrix.length;
         int n = matrix[0].length;
         int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
