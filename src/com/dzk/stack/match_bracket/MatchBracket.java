package com.dzk.stack.match_bracket;

import java.util.Stack;

/**
 * 括号匹配
 * "()[]{}"
 *
 * Output : true
 */
public class MatchBracket {
    public static void main(String[] args) {
        boolean isValid =  isValid("({}[])");
        System.out.println(isValid);
    }


    private static boolean isValid(String str) {
        if (str == null || str.isEmpty()){
            return true;
        }

        Stack<Character> stack = new Stack<>();
        char[] ch = str.toCharArray();
        for (char c : ch){
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char p = stack.pop();
                boolean b1 = c == ')' && p != '(';
                boolean b2 = c == ']' && p != '[';
                boolean b3 = c == '}' && p != '{';
                if (b1 || b2 || b3){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
