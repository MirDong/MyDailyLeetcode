package com.dzk.study.link;

import com.dzk.list.ListNode;

/**
 * 判断有环，快慢指针解决
 */
public class HasCycle {
    private static boolean hasCycle(ListNode head){
        if (head == null || head.next == null) return false;
        ListNode fast = head,slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
