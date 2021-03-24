package com.dzk.study;

/**
 * 实现一个pow方法
 */
public class Pow {
    public static void main(String[] args) {
//        System.out.println(Math.pow(2,-1));
        System.out.println(pow(2,-3));
    }

    /**
     * 递归实现
     * @param x
     * @param n
     * @return
     */
    private static double myPow(int x, int n){
        if (x == 0) throw new IllegalArgumentException("x is illegal value");
        if (n == 0) return 1;
        if (n < 0) return 1 / myPow(x,-n);
        double half = myPow(x,n / 2) ;
        if (n % 2 == 0){
           return half * half;
        }
        return half * half * x;
    }

    private static double pow(double x, int n){
        if (n == 0) return 1;
        if (n < 0){
            x = 1 / x;
            n = -n;
        }
        double pow = 1;
        while (n != 0){
            if ((n & 1) != 0){
                pow *= x;
            }
            x *= x;
            n >>= 1;
        }
        return pow;
    }
}
