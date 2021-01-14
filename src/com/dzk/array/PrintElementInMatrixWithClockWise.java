package com.dzk.array;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * 顺时针打印矩阵
 * 按顺时针的方向，从外到里打印矩阵的值。下图的矩阵打印结果为：1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
 *
 *      1  2  3  4
 *      5  6  7  8
 *      9  10 11 12
 *      13 14 15 16
 *
 *      17 18 19 20
 *
 *      需要注意的是，每一行/每一列打印，在拐角处不能重复打印
 *
 *      解题思路: 顺时针打印，即外围打印，找好外围边界值，即rl(行头)rb(行尾)cl(列头)cr(列尾)
 *      第一轮打印完毕后，按照原来的规则打印第二轮..依次打印各轮，直到rt > rb  cl>cr
 *
 *
 *
 *      java.lang.ArrayIndexOutOfBoundsException: Index 12 out of bounds for length 12
 *   at line 28, Solution.spiralOrder
 *   at line 57, __DriverSolution__.__helper__
 *   at line 82, __Driver__.main
 */
public class PrintElementInMatrixWithClockWise {

    public static void main(String[] args) {
        BitSet bitSet = new BitSet(128);
        System.out.println(bitSet.length());
//        int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
//        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> clockPathList = printInClockWise(input);
        if (clockPathList != null){
            for (Integer val:clockPathList) {
                System.out.print( val + " ");
            }
        }else {
            System.out.println("传入的矩阵为空");
        }
    }

    private static List<Integer> printInClockWise(int[][] input) {
        List<Integer> pathList = new ArrayList<>();
        if (input == null || input.length < 1 || input[0].length < 1){
            return pathList;
        }

        int rt = 0;//第一行
        int rb = input.length - 1;//最后一行

        int cl = 0;//第一列
        int cr = input[0].length - 1;//最后一列

        while (rt <= rb && cl <= cr){
            //上
            for (int i = cl; i <= cr; i++) {
                pathList.add(input[rt][i]);
            }

            //右
            for (int i = rt + 1; i <= rb; i++) {
                pathList.add(input[i][cr]);
            }

            //下
            if (rt != rb){
                for (int i = cr - 1; i >= cl ; i--) {
                    pathList.add(input[rb][i]);
                }
            }

            //左
            if (cl != cr){
                for (int i = rb - 1; i > rt ; i--) {
                    pathList.add(input[i][cl]);
                }
            }

            rt++;
            rb--;
            cl++;
            cr--;
        }
        return pathList;
    }


    /*作者：jyd
    链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    */
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;
    }

}
