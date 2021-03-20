package com.dzk.homework.list;

import com.dzk.list.ListNode;

/**
 * 相交链表
 *
 编写一个程序，找到两个单链表相交的起始节点
 * a1->a2->c1->c2->c3
 * b1->b2->b3->c1->c2->c3
 *
 * a + c + b = b + c + a;
 */
public class CrossList {

    private ListNode crossListPoint(ListNode headA,ListNode headB){
        if (headA == null || headB == null) return null;
        ListNode listA = headA;
        ListNode listB = headB;
        while (listA != listB){
            listA = listA.next == null ? headB:listA.next;
            listB = listB.next == null ? headA:listB.next;
        }
        return listA;
    }
}
