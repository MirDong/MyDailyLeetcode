package com.dzk.integer;

/**
 * 123 翻转成 321
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverseInteger2(123456));
    }

    //解题思路一  需要考虑超出int类型最大值的情况
    private static int reverseInteger(int value){
        int n = 0;
        while (value != 0){
            n = n * 10 + value % 10;
            value /= 10;
        }
        return n;
    }

    //解题思路二,转换成String类型去计算
    private static int reverseInteger2(int value){
        String convertStr = String.valueOf(value);
        char[] charArray = convertStr.toCharArray();
        boolean isOverZero = true;
        StringBuilder sb = new StringBuilder();
        for (int i = charArray.length -1;i >= 0; i--){
            if (charArray[i] == '-'){
                isOverZero = false;
                continue;
            }
            sb.append(charArray[i]);
        }
        String res = sb.toString();
        int result = Integer.valueOf(res);
        if (!isOverZero){
            result *= -1;
        }
        return result;
    }
}
