package com.linmu.q129;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/28 1:51 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q129 {
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
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int i){
        if (root == null) return 0;
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null)
            return temp;
        return helper(root.left, temp) + helper(root.right, temp);
    }
}
