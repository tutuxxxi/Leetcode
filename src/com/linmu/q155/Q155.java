package com.linmu.q155;

import org.w3c.dom.Node;

import java.util.Stack;

/**
 * @author ：xxx_
 * @date ：Created in 2021/6/11 11:47 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q155 {
    public static void main(String[] args) {

    }
}

class MinStack {

    class Node{
        int val;
        Node next;
    }

    private Node root;

    public MinStack() {
        root = new Node();
    }

    public void push(int val) {
        Node node = new Node();
        node.val = val;
        node.next = root.next;
        root.next = node;
    }

    public void pop() {
        if(root.next != null){
            root.next = root.next.next;
        }
    }

    public int top() {
        if(root.next != null){
            return root.next.val;
        }
        return 0;
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        Node index = root.next;
        while(index != null){
            min = Math.min(min, index.val);
            index = index.next;
        }
        return min;
    }
}