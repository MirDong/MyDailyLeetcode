package com.dzk.device_and_rule;

import java.util.ArrayList;
import java.util.List;

/**
 *给表达式加括号，分治算法
 */
public class DifferentWayToAddParentheses {
    public static void main(String[] args) {
        String input = "2-1-1";
        List<Integer> result = differentWayToCalc(input);
        System.out.println(result);
    }

    private static List<Integer> differentWayToCalc(String input) {
        List<Integer> res = new ArrayList<>();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*'){
                List<Integer> left = differentWayToCalc(input.substring(0,i));
                List<Integer> right = differentWayToCalc(input.substring(i+1));
                for (int l: left){
                    for (int r: right){
                        switch (c){
                            case '+':
                                res.add(l + r);
                                break;
                            case '-':
                                res.add(l - r);
                                break;
                            case '*':
                                res.add(l * r);
                                break;
                        }
                    }
                }
            }

        }
        if (res.size() == 0){
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}
