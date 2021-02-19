package com.dzk.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
//        printListNode(listNode);
//        List<Integer> nodeValueList = printListNodeWithInsertHead(listNode);
        List<Integer> nodeValueList = printListNodeWithStack(listNode);
        System.out.println(nodeValueList);
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
//方法二 头插法
    private static List<Integer> printListNodeWithInsertHead(ListNode listNode){
        if (listNode == null ){
            throw new IllegalArgumentException("ListNode is null");
        }

        ListNode head = new ListNode(-1);
        while (listNode != null){
            ListNode tempNext = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = tempNext;
        }

        ListNode node = head.next;
        while (node != null){
            list.add(node.value);
            node = node.next;
        }
        return list;
    }

    //方法三  使用栈
    private static List<Integer> printListNodeWithStack(ListNode listNode){
        if (listNode == null ){
            throw new IllegalArgumentException("ListNode is null");
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.value);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

}
