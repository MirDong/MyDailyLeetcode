package com.dzk.array;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 * Given target = 20, return false.
 *
 * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
 */
public class FindNumberInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        boolean found = findInMatrix(matrix,matrix.length ,matrix[0].length ,0,matrix[0].length-1 ,20);
        boolean found2 = findInMatrix(matrix,20);
        System.out.println("回溯法是否找到: "+found);
        System.out.println("循环法是否找到: "+found2);
    }

    private static boolean findInMatrix(int[][] matrix, int targetNum) {
        if (matrix == null || matrix.length == 0 ||matrix[0].length == 0){
            return false;
        }else if (targetNum < matrix[0][0] || targetNum > matrix[matrix.length - 1][matrix[0].length - 1]){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        while (row <= rows - 1 && col >= 0){
            if (targetNum == matrix[row][col]){
                return true;
            }else if (targetNum < matrix[row][col]){
                --col;
            }else {
                ++row;
            }
        }
        return false;
    }

    /**
     * 使用回溯法解决
     * @param matrix
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param targetNum
     * @return
     */
    private static boolean findInMatrix(int[][] matrix,int rows,int cols,int row,int col,int targetNum){
        if (matrix == null || rows <= 0 || cols <= 0){
            return false;
        }else if (targetNum < matrix[0][0] || targetNum > matrix[rows-1][cols-1]){
            return false;
        }else if (row > rows-1 || col < 0){
            return false;
        }

        int rightTop = matrix[row][col];
        if (targetNum == rightTop){
            return true;
        }else if (targetNum < rightTop){
           return findInMatrix(matrix, rows, cols, row, col - 1, targetNum);
        }else {
           return findInMatrix(matrix, rows, cols, row + 1, col, targetNum);
        }
    }
}
