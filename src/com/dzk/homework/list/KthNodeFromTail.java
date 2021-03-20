package com.dzk.homework.list;

import com.dzk.list.ListNode;

/**
 * 链表中倒数第k个节点
 */
public class KthNodeFromTail {
    public static void main(String[] args) {
        int[] a;
        String str;
    }
    private ListNode getKthFromEnd(ListNode head,int k){
        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        //TODO fast 先走k步
        while (k-- > 0){
            fast = fast.next;
        }
        //TODO fast 与 slow一起走 length(链表长度)
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
