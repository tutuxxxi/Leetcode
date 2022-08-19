package com.linmu.q1302;

import javax.swing.text.EditorKit;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author by lijun
 * @date 2022/8/17 8:34
 */
public class Q1302 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);
        treeNode.right.right.right = new TreeNode(8);
        System.out.println(new Solution().deepestLeavesSum(treeNode));
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
    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        int size;
        while((size = deque.size()) != 0) {
            int count = 0;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                count += treeNode.val;
                if(treeNode.left != null) {
                    deque.offerLast(treeNode.left);
                }
                if(treeNode.right != null) {
                    deque.offerLast(treeNode.right);
                }
            }
            if(deque.isEmpty()) {
                return count;
            }
        }
        return -1;
    }
}
