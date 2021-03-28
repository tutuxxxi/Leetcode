package com.linmu.q173;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/28 8:44 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q173 {
    public static void main(String[] args) {
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {

    private Queue<Integer> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList();
        saveNode(root);
    }

    private void saveNode(TreeNode node){
        if(node.left != null){
            saveNode(node.left);
        }
        queue.offer(node.val);
        if(node.right != null){
            saveNode(node.right);
        }
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
