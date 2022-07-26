package com.linmu.q116;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/18 4:31 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q116 {
    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        if(root != null) {
            if(root.left != null && root.right != null){
                root.left.next = root.right;
                if (root.next != null) {
                    root.right.next = root.next.left;
                }
                connect(root.left);
                connect(root.right);
            }
        }
        return null;
    }
}
