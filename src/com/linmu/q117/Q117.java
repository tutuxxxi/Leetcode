package com.linmu.q117;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/24 9:21 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q117 {
    public static void main(String[] args) {
        Node node = new Node(3, new Node(9, null, null, null), new Node(20, new Node(15), new Node(7), null), null);
        new Solution().connect(node);
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
}

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        if(root.left!=null && root.right!=null){
            root.left.next=root.right;
        }
        if(root.left!=null && root.right==null){
            root.left.next=getNext(root.next);
        }
        if(root.right!=null)
            root.right.next=getNext(root.next);
        connect(root.right);
        connect(root.left);
        return root;
    }

    public Node getNext(Node root){
        if(root==null) return null;
        if(root.left!=null) return root.left;
        if(root.right!=null) return root.right;
        if(root.next!=null) return getNext(root.next);
        return null;
    }
}
