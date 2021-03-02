package com.dzk.list;

/**
 *链表中倒数第 K 个结点
 * 解题思路:设链表的长度为 N。设置两个指针 P1 和 P2，先让 P1 移动 K 个节点，则还有 N - K 个节点可以移动。
 * 此时让 P1 和 P2 同时移动，可以知道当 P1 移动到链表结尾时，P2 移动到第 N - K 个节点处，该位置就是倒数第 K 个节点。
 */
public class KthElement {
    public static void main(String[] args) {
        ListNode node = makeListNode(6);
        ListNode kthNode = findKthToTail(node, 5);
        System.out.println(kthNode.value);
    }

    private static ListNode makeListNode(int num) {
        ListNode node = null;
        for (int i = 0; i < num; i++) {
            node = new ListNode(i + 1,node);
        }
        return node;
    }

    private static ListNode findKthToTail(ListNode head,int k){
        if (head == null){
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        //链表长度为n，p1先走k个节点
        while (p1 != null && k-- > 0){
            p1 = p1.next;
        }
        //当p1 == null表示链表的长度n小于k
        if (p1 == null){
            return null;
        }
        //p1到链表尾部有n-k个节点，p1、p2同时沿着链表往尾部走，当p1走到链表尾部时，
        // p2所处的位置正好是尾部向头部的第k个节点
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
