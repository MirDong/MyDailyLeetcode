package com.dzk.double_pointer;

/**
 * 翻转单词顺序列
 * Input:
 * "I am a student."
 *
 * Output:
 * "student. a am I"
 * 解题思路：先翻转每个单词，再翻转整个字符串
 */
public class ReverseSentence {
    public static void main(String[] args) {
        String src = "I am a student.";
        int length = src.length();
        String result = reverseSentence(src,length);
        System.out.println(result);
    }

    private static String reverseSentence(String src, int length) {
        if (src == null || length == 0){
            return new String();
        }
        int j = 0;
        char[] c = src.toCharArray();
        for (int i = 0; i <= length; i++) {
            if (i == length  || c[i] == ' '){
                reverse(c,j,i - 1);
                j = i + 1;
            }

        }
        reverse(c,0,length - 1);
        return new String(c);
    }

    private static void reverse(char[] c, int j, int i) {
        while (j < i){
            swap(c,j++,i--);
        }
    }

    private static void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
