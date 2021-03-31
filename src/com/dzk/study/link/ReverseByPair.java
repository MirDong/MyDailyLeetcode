package com.dzk.study.link;

import com.dzk.list.ListNode;

/**
 * 成对翻转
 */
public class ReverseByPair {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));
        ListNode res = reverseByPair(head);
//        ListNode res = swapPairs(head);
        System.out.println(res);

    }
    private static ListNode reverseByPair(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode prev = root;
        ListNode cur = null;
        while (prev.next != null && prev.next.next != null){
            cur = prev.next.next;

            prev.next.next = cur.next;
            cur.next = prev.next;
            prev.next = cur;

            prev = cur.next;
        }
        return root.next;
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy, p2;
        while(p1.next != null && p1.next.next != null) {
            p2 = p1.next.next;
            p1.next.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
        }
        return dummy.next;
    }
}
