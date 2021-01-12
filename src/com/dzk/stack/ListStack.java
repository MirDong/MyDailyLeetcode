package com.dzk.stack;

import java.util.Iterator;

/**
 * 堆栈基于链表实现
 */
public class ListStack<Item> implements MyStack<Item>{
    private Node top = null;
    private int N = 0;
    class Node {
        Item item;
        Node next;
    }
    @Override
    public MyStack<Item> push(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = top;
        /*if (top == null){
            top = node;
        }else {
            top.next = node;
            top = top.next;
        }*/

        top = node;
        N++;
        return this;
    }

    @Override
    public Item pop() throws Exception {
        if (isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        Item item = top.item;
        /*Node nextNode = top.next;
        top.next = null;
        top = nextNode;*/
        top = top.next;
        N--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node cur = top;
            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public Item next() {
                Item item = cur.item;
                cur = cur.next;
                return item;
            }
        };
    }
}
