package com.dzk.backtrack;

import java.util.*;

/**
 * N皇后问题
 *
 */
public class NQueens {
    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(1);
        System.out.println(lists.toString());
    }

    /**
     *解题一  利用回溯法暴力搜索尝试所有的路径，在一条路径上走不通时，回退再重新选择另外一条路径，直到尝试完所有的路径，得到可行的路径集合
     * @param n  1 =< n <= 9
     * @return
     */
    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        int[] queen = new int[n];
        Arrays.fill(queen,-1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> left_diagonals = new HashSet<>();
        Set<Integer> right_diagonals = new HashSet<>();
        backstack(solution,queen,n,0,columns,left_diagonals,right_diagonals);
        return solution;
    }

    private static void backstack(List<List<String>> solution, int[] queen, int n, int row, Set<Integer> columns, Set<Integer> left_diagonals, Set<Integer> right_diagonals) {
        if (row == n){
            List<String> result = createMatrixNode(queen,n);
            solution.add(result);
        }else {
            for (int i = 0; i < n; i++){
                if (columns.contains(i)){
                    continue;
                }

                int diagonal = row - i;
                if (left_diagonals.contains(diagonal)){
                    continue;
                }

                int diagonal2 = row + i;
                if (right_diagonals.contains(diagonal2)){
                    continue;
                }

                queen[row] = i;
                columns.add(i);
                left_diagonals.add(diagonal);
                right_diagonals.add(diagonal2);
                backstack(solution,queen,n,row + 1,columns,left_diagonals,right_diagonals);
                queen[row] = -1;
                columns.remove(i);
                left_diagonals.remove(diagonal);
                right_diagonals.remove(diagonal2);
            }
        }
    }

    private static List<String> createMatrixNode(int[] queen, int n) {
        List<String> container = new ArrayList<>();
        for (int i = 0; i < n; i++){
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[queen[i]] = 'Q';
            container.add(new String(row));
        }
        return container;
    }


}
