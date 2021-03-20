package com.dzk.homework.list;

import com.dzk.list.ListNode;

/**
 * 两数相加
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoListNode {
    private ListNode addTwoListNode(ListNode l1,ListNode l2){
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1.next != null){
            p1 = p1.next;
        }

        while(p2.next != null){
            p2 = p2.next;
        }

        ListNode newNode = new ListNode(p1.value + p2.value);
//        add(p1,p2);
        return null;
    }
}
