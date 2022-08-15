package com.linmu.q623;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author by lijun
 * @date 2022/8/5 13:34
 */
public class Q623 {
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

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth-- == 1) {
            return new TreeNode(val, root, null);
        }

        // 层次遍历
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while(--depth > 0) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.removeFirst();
                if(treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }
                if(treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }
            }
        }

        // build
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            TreeNode treeNode = deque.removeFirst();
            treeNode.left = new TreeNode(val, treeNode.left, null);
            treeNode.right = new TreeNode(val, null, treeNode.right);
        }
        return root;
    }
}
