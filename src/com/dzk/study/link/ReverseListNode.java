package com.dzk.study.link;

import com.dzk.list.ListNode;


/**
 * 翻转链表
 */
public class ReverseListNode {
    private static ListNode reverse(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private static ListNode reverseByRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseByRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
