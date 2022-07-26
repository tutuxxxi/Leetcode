package com.linmu.q430;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/24 8:44 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q430 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.child = node2;
        node2.child = node3;

        new Solution().flatten(node1);
    }
}



class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    Node(int val) {
        this.val = val;
    }
};

class Solution {
    public Node flatten(Node head) {
        Node operator = head;

        while(operator != null) {
            if(operator.child != null) {
                // 子结点扁平化
                Node flatten = flatten(operator.child);

                // 插入
                while(flatten.next != null) {
                    flatten = flatten.next;
                }


                if(operator.next != null) {
                    operator.next.prev = flatten;
                    flatten.next = operator.next;
                }
                operator.next = operator.child;
                operator.child.prev = operator;

                operator.child = null;
            }
            operator = operator.next;
        }

        return head;
    }
}
