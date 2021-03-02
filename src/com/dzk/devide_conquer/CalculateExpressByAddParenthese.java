package com.dzk.devide_conquer;

import java.util.ArrayList;
import java.util.List;

/**
 * # 1. 给表达式加括号，利用分治算法
 */
public class CalculateExpressByAddParenthese {
    public static void main(String[] args) {
        List result = diffWaysToCompute("2-1-1+1+3-1");
        System.out.println(result.toString());
    }

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }


    private List<Integer> calculate(String express){
        List<Integer> ways = new ArrayList<>();
        if (express == null || express.isEmpty()){
            return ways;
        }

        char[] chars = express.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char ch = chars[i];
            List<Integer> left = calculate(express.substring(0,i));
            List<Integer> right = calculate(express.substring(i +1));
            if (ch == '+' || ch == '-' || ch == '*'){
                for (int l:left){
                    for (int r:right){
                        switch (ch){
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0){
            ways.add(Integer.valueOf(express));
        }
        return ways;
    }
}
