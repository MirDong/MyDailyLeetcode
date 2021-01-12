package com.dzk.queue;

import java.util.Iterator;

public class ListQueue<Item> implements IQueue<Item> {
    private Node first;
    private Node last;
    private int N = 0;

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node cur = first;
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

    class Node {
        Item item;
        Node next;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public IQueue<Item> add(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        N++;
        return this;
    }

    @Override
    public Item remove() throws Exception {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()){
            last = null;
        }
        return item;
    }
}
