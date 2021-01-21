package com.dzk.search;

/**
 * 求开方  Sqrt(x)
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(64));
    }

    private static int sqrt(int value){
        // 0或 1
        if (value < 2){
            return value;
        }

        int left = 2;
        int right = value;
        int middle;
        while (left <= right){
            middle = left + (right - left) / 2;
            if (middle * middle == value){
                return middle;
            }else if (middle * middle < value){
                left = middle + 1;
            }else {
                right = middle - 1;
            }
        }
        return right;
    }

}
