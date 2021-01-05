package com.dzk.dynamicplan;

/**
 * 给你一根长度为n绳子,请把绳子剪成m段(m,n都是整数，n>1且m>1),
 * 每段绳子的长度记为k[0],k[1]...k[m]。请问k[0]xk[1]...xk[m]可能的最大乘积
 * 是多少?例如,当绳子的长度是8时,我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
 * 方法一:动态规划
 * 方法二:贪婪法
 */
public class ProductDynamicPlan {
    public static void main(String[] args) {
        int maxValue = getMaxProductByDynamicPlan(50);
//        int maxValue = getMaxProductByGreed(50);
        System.out.println(maxValue);
    }

    /**
     * 贪婪法  当n>= 5时，3*(n-3) > n ， 2*(n-2)>n,并且3*(n-3) >= 2*(n-2)
     * 所以每次剪断3，直至最后，当剩余长度为1时，回退上一步，使得最后剩下的长度为4，按照长度为2 进行剪， 2 * 2 > 1 * 3
     * @param length
     * @return
     */
    private static int getMaxProductByGreed(int length) {
        if (length < 2){
            return 0;
        }else if (length == 2){
            return 1;
        }else if (length == 3){
            return 2;
        }
            int threeOfCount = length / 3;
            int tail = length % 3;
            if (tail == 1){
                threeOfCount-=1;
                tail += 3;
            }
        int twoOfCount  = tail / 2;
        int threePow = (int)(Math.pow(3,threeOfCount));
        System.out.println("threePow = " + threePow);
        int twoPow =  (int)(Math.pow(2,twoOfCount));
        System.out.println("twoPow = " + twoPow);
        return threePow * twoPow;
    }

    /**
     * 动态规划
     * @param length
     * @return
     */
    private static int getMaxProductByDynamicPlan(int length){
        if (length < 2){
            return 0;
        }else if (length == 2){
            return 1;
        }else if (length == 3){
            return 2;
        }
        int max = 0;
        int[] container = new int[length + 1];
        container[0] = 0;
        container[1] = 1;
        container[2] = 2;
        container[3] = 3;
        for (int i = 4; i <=length; i++) {
            max = 0;
            for (int j = 1; j <= i/2; j++) {
                int product = container[j] * container[i - j];
                if (max < product){
                    max = product;
                }
            }
            container[i] = max;
        }
        max = container[length];
        return max;
    }
}
