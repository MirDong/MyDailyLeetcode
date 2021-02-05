package com.dzk.stack.min_method;


import java.util.Stack;

/**
 * 实现包含min函数的栈，该方法返回当前栈中最小的值
 */
public class MinMethodInStack {
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> miniStack = new Stack<>();
    public static void main(String[] args) {
        MinMethodInStack stack = new MinMethodInStack();
        stack.push(5);
        stack.push(7);
//        stack.push(1);
        System.out.println(stack.min());
    }

    public int push(int item){
        dataStack.push(item);
        miniStack.push(miniStack.isEmpty() ? item: Math.min(miniStack.peek(),item));
        return item;
    }

    public int pop(){
        int item = dataStack.pop();
        miniStack.pop();
        return item;
    }

    public int top(){
        return dataStack.peek();
    }
    public int min(){
        return miniStack.peek();
    }
}
