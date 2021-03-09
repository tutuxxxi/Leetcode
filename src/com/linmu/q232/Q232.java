package com.linmu.q232;

import java.util.Stack;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/5 14:35
 * @description：
 * @modified By：
 * @version:
 */
public class Q232 {
    public static void main(String[] args) {

    }
}


class MyQueue {

    Stack<Integer> stack;
    Stack<Integer> reverseStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack();
        reverseStack = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        ensure();

        return reverseStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        ensure();

        return reverseStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && reverseStack.isEmpty();
    }

    private void ensure(){
        if(reverseStack.isEmpty()){
            while(!stack.isEmpty()){
                reverseStack.push(stack.pop());
            }
        }
    }
}