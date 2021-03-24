package com.dzk.study.dynamic_plan;

/**
 * 爬楼梯，一次只能爬一个台阶或2个台阶
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbing(5));
        System.out.println(climbing2(5));
        System.out.println(climbing3(5));
    }

    //first
    private static int climbing(int n){
        if (n <= 3) return n;
        return climbing(n - 1) + climbing(n - 2);
    }

    //second
    private static int climbing2(int n){
        if (n <= 3) return n;
        int i = 4;
        int prev = 2;
        int cur = 3;
        int temp;
        while (i++ <= n){
            temp = cur;
            cur += prev;
            prev = temp;
        }
        return cur;
    }

    //third
    private static int climbing3(int n){
        int f0 = 1;
        int f1 = 1;
        int temp;
        while (n-- > 1){
            temp = f1;
            f1 += f0;
            f0 = temp;
        }
        return f1;
    }
}
