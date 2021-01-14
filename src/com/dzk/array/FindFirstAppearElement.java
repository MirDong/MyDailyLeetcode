package com.dzk.array;

import java.util.BitSet;

/**
 * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。字符串只包含 ASCII 码字符。
 * Input: abacc
 * Output: b
 *
 * ASCII 从0 ~ 127 共计128个元素
 * 解题思路：
 * 解题1.创建一个长度为128的数组，记录下标0 ~ 127 每一个下标对应的元素出现的次数，存储在数组中，然后遍历数组
 * 解题2.使用两个BitSet解决，因为出现的次数无非为0，1，更多  使用两个BitSet记录出现次数多余1的元素
 */
public class FindFirstAppearElement {
    public static void main(String[] args) {
        String rawStr = "abacc";
        int position = FirstNotRepeatingChar(rawStr);
        System.out.println(rawStr.charAt(position));
    }

    private static int FirstNotRepeatingChar(String rawStr) {
        if (rawStr == null || rawStr.length() == 0){
            return -1;
        }
        BitSet bitSet = new BitSet(128);//16个字节
        BitSet bitSet2 = new BitSet(128);//16个字节
        for (char c : rawStr.toCharArray()) {
            if (!bitSet.get(c) && !bitSet2.get(c)){
                bitSet.set(c);
            }else if (bitSet.get(c) && !bitSet2.get(c)){
                bitSet2.set(c);
            }
        }

        for (int i = 0; i < rawStr.length(); i++) {
            if (bitSet.get(rawStr.charAt(i)) &&!bitSet2.get(rawStr.charAt(i))){
                return i;
            }
        }
        return -1;
    }
}
