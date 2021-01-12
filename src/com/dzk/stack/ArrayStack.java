package com.dzk.stack;

import java.util.Iterator;

/**
 * 堆栈基于数组实现
 */
public class ArrayStack<Item> implements MyStack<Item>{
    //栈元素数组
    private Item[] items = (Item[]) new Object[1];
    //元素数量
    private int N = 0;
    @Override
    public MyStack<Item> push(Item item) {
        check();
        items[N++] = item;
        return this;
    }

    private void check() {
        if (N >= items.length){
            resize(2 * items.length);
        }else if (N > 0 && N < items.length / 4){
            resize(items.length / 2);
        }
    }

    /**
     * 动态调整数组长度,使栈具有伸缩性
     * @param size
     */
    private void resize(int size) {
        Item[]  newItem = (Item[]) new Object[size];
        for (int i = 0; i < N; i++) {
            newItem[i] = items[i];
        }
        items = newItem;
    }

    @Override
    public Item pop() throws Exception {
        if (isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        Item item = items[--N];
        check();
        items[N] = null;
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
            int i = N;
            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public Item next() {
                return items[--i];
            }
        };
    }
}
