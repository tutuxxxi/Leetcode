package com.linmu.q114;

import java.util.TreeMap;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/18 4:08 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q114 {
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
    public void flatten(TreeNode root) {
        change(root);
    }

    /**
     * 转化并返回末尾指针
     * @param root
     * @return
     */
    public TreeNode change(TreeNode root) {
        if(root != null) {
            TreeNode right = root.right;
            TreeNode leftTail = change(root.left);
            TreeNode rightTail = change(root.right);

            if(root.left != null) {
                root.right = root.left;
                root.left = null;
                root = leftTail;
            }
            if(right != null) {
                root.right = right;
                root = rightTail;
            }
        }
        return root;
    }
}
