package com.linmu.q124;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/28 10:35 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q124 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10, new TreeNode(-19), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        new Solution().maxPathSum(treeNode);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode root){
        if(root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        // 每一次子树遍历都进行一次最大值尝试替换， 避免了分叉情况的出现
        maxSum = Math.max(maxSum, root.val + left + right);
        return Math.max(left, right) + root.val;
    }
}
