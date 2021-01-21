package com.dzk.reverse;

/**
 * int 类型数据翻转，注意控制好翻转后的int类型边界：-2的31次方~2的31次方，如果超过返回0
 */
public class IntegerReverse {
    public static void main(String[] args) {

        System.out.println(reverseInteger(-123));
        System.out.println(reverseInteger(120));
        System.out.println(reverseInteger(78674123));
    }

    private static int reverseInteger(int num) {
        int temp = 0;
        while (num != 0){
           temp =  temp *10 + num % 10;
           num  = num / 10;
        }

        if (num < (-1) * Math.pow(2,31) || num > Math.pow(2,31) - 1){
            return 0;
        }
        return temp;
    }
}
