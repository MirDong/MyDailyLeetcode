package com.dzk;

import com.dzk.list.ListNode;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1,null);
        ListNode listNode = new ListNode(1,null);
        head.next = listNode;
        for (int i = 1; i < 5; i++) {
            ListNode listNodeNext = new ListNode(i + 1,null);
            listNode.next = listNodeNext;
            listNode = listNode.next;
        }
        ListNode node = swapNodes(head.next, 2);
        System.out.println(node);
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode swapNodes(ListNode head, int k) {
        if(k <= 0 || head == null || head.next == null){
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = head;

        while(k-- > 0){
            p1 = p1.next;
            p3 = p3.next;
        }

        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        int temp = p2.val;
        p2.val = p3.val;
        p3.val = temp;
        return head;

    }
}
