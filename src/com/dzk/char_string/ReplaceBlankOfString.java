package com.dzk.char_string;

/**
 * 将一个字符串中的空格替换成 "%20"
 * Input:
 * "A B"
 *
 * Output:
 * "A%20B"
 * 解題思路：
 * 1.遍历字符串，遇到空字符，长度增加2   目的是保持长度与替换空格后的长度相同
 * 2.使用双指针，一个指针指向原始字符串的尾部，另一个指向新字符串(长度扩展)的尾部
 * 3.从后往前依次遍历，直至两个指针重逢
 *
 */
public class ReplaceBlankOfString {
    public static void main(String[] args) {
//        String str = "  A B";
//        String str = "  A B  ";
        String str = "    ";
        String result = replaceBlank(str);
        System.out.println(result);
    }

    private static String replaceBlank(String str){
        if (str == null || str.length() == 0){
            return str;
        }

        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                sb.append(" ").append(" ");
            }
        }

        int pHead = str.length() - 1;
        int pTail = sb.length() - 1;
        while (pHead >= 0 && pTail >= 0 && pHead <= pTail){
            if (sb.charAt(pHead) != ' '){
                sb.setCharAt(pTail--,sb.charAt(pHead--));
            }else {
                sb.setCharAt(pTail--,'0');
                sb.setCharAt(pTail--,'2');
                sb.setCharAt(pTail--,'%');
                pHead--;
            }
        }
        return sb.toString();
    }
}
