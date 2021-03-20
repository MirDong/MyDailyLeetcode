package com.dzk.homework.list;

import com.dzk.list.ListNode;

import java.util.List;

/**
 * 判断链表中是否包含循环链表，循环链表的头结点
 */
public class IsContainLoopList {
    public static void main(String[] args) {
        ListNode loopList = new ListNode(4,null);
        ListNode list = new ListNode(5,loopList);
        loopList.next = list;
        ListNode node = new ListNode(1,new ListNode(2,new ListNode(3,
                loopList)));
        System.out.println(isContainLoop(node));
    }

    /**
     * 快慢指针解决，如果快慢指针相遇，则是循环链表
     * @param root
     * @return
     */
    private static boolean isContainLoop(ListNode root){
        if (root == null || root.next == null) return false;
        ListNode slow = root;
        ListNode fast = root;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow.value == fast.value && slow.next == fast.next){
                return true;
            }
        }
        return false;
    }
}
