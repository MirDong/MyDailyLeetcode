package com.dzk.homework.list;

import com.dzk.list.ListNode;

/**
 * 合并单链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoListNode {

    private ListNode mergeListNode(ListNode l1,ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        //TODO refactor compare
        if (l1.value < l2.value){
            l1.next = mergeListNode(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeListNode(l1,l2.next);
            return l2;
        }
    }
}
