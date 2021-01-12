package com.dzk.queue;

public interface IQueue<Item> extends Iterable<Item>{
    int size();
    boolean isEmpty();
    IQueue<Item>add(Item item);
    Item remove() throws Exception;
}
