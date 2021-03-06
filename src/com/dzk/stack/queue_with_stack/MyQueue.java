package com.dzk.stack.queue_with_stack;

import java.util.Stack;

/**
 * 用栈实现队列
 * 栈的顺序为后进先出，而队列的顺序为先进先出。使用两个栈实现队列，一个元素需要经过两个栈才能出队列，
 * 在经过第一个栈时元素顺序被反转，经过第二个栈时再次被反转，此时就是先进先出顺序。
 */
public class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer>outStack;
    public MyQueue(){
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public int pop(){
        in2out();
        return outStack.pop();
    }

    public void push(int value){
        inStack.push(value);
    }

    public int peek(){
        in2out();
        return outStack.peek();
    }

    private void in2out(){
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
    }
}
