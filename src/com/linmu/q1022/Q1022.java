package com.linmu.q1022;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：xxx_
 * @date ：Created in 2022/5/30 16:31
 * @description：
 * @modified By：
 * @version:
 */
public class Q1022 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(1), null);
        new Solution().sumRootToLeaf(root);
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
    public int sumRootToLeaf(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while(!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.removeFirst();
                if(treeNode != null) {
                    if(treeNode.left == null && treeNode.right == null) {
                        // 叶子节点
                        ans += treeNode.val;
                    }else {
                        if(treeNode.left != null) {
                            // 进位加值
                            treeNode.left.val += treeNode.val << 1;
                            deque.addLast(treeNode.left);
                        }
                        if(treeNode.right != null) {
                            // 进位加值
                            treeNode.right.val += treeNode.val << 1;
                            deque.addLast(treeNode.right);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
