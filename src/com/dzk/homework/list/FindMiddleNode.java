package com.dzk.homework.list;

import com.dzk.list.ListNode;

/**
 * 一次链表遍历中，找到链表中间节点的值
 */
public class FindMiddleNode {
    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        System.out.println(findMiddleNode(node));
    }


    private static int findMiddleNode(ListNode root){
        if (root == null || root.next == null) return -1;
        ListNode slow = root;
        ListNode fast = root;
        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.value;
    }
}
