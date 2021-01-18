package com.dzk.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 从尾到头反过来打印出每个结点的值。
 * 从尾到头打印链表
 *
 * 1 -> 2 -> 3    output: 3,2,1
 */
public class PrintListNodeFromTailToHead {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {

        ListNode listNode = createListNode();
        printListNode(listNode);
    }

    private static ListNode createListNode() {
        ListNode node = new ListNode(3,null);
        ListNode node2 = new ListNode(2,node);

        ListNode pHeader = new ListNode(1,node2);
        return pHeader;
    }


    //方法一:递归
    private static List<Integer> printListNode(ListNode listNode){
        if (listNode == null){
            return null;
        }

        printListNode(listNode.next);
        System.out.println(listNode.value);
        list.add(listNode.value);
        return list;
    }


}
