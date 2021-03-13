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

    private static char nextGreaterLetterThanTarget2(char[] letters,char target) {
        int l = 0;
        int h = letters.length - 1;
        while (l <= h){
            int m = l + (h -l) / 2;
            if (letters[m] > target){
                h = m - 1;
            }else {
                l = m + 1;
            }
        }
        return l < letters.length ? letters[l]:letters[0];
    }

}
