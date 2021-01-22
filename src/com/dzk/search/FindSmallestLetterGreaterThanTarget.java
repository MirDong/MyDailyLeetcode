package com.dzk.search;

/**
 * 大于给定元素的最小元素
 * Find Smallest Letter Greater than Target
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 * 题目描述:给定一个有序的字符数组 letters 和一个字符 target，要求找出 letters 中大于 target 的最小字符，如果找不到就返回第 1 个字符
 */
public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'k';
        System.out.println(nextGreaterLetterThanTarget(letters,target));
    }

    private static char nextGreaterLetterThanTarget(char[] letters,char target) {
        int length = letters.length;
        int left = 0;
        int right = length - 1;
        while (left <= right){
            int mid =left + (right - left) / 2;
            if (letters[mid] <= target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return  left < length ? letters[left]:letters[0];
    }
}
