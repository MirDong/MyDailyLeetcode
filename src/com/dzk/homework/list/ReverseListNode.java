package com.dzk.homework.list;

import com.dzk.list.ListNode;

import java.util.HashMap;
import java.util.List;

/**
 * 逆转单链表
 */
public class ReverseListNode {
    ListNode prevNode;
    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(2,new ListNode(3,null)));
        ListNode reversedList = reverseByRecursion(node);
        System.out.println(reversedList);
    }

    /**
     * 递归方式实现
     * @param listNode
     * @return
     */
    private static ListNode reverseByRecursion(ListNode listNode){
        if (listNode == null || listNode.next == null) return listNode;
         ListNode res = reverseByRecursion(listNode.next);
        listNode.next.next = listNode;
        listNode.next = null;
        return res;
    }
    /**
     * 遍历链表，按序拼接链表，头插法
     * @param root
     * @return
     */
    private static ListNode reverse(ListNode root){
        if (root == null || root.next == null) return root;
        ListNode cur = root;
        ListNode head = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        return head;
    }
}
