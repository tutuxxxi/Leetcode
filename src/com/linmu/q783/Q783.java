package com.linmu.q783;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/13 9:07 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q783 {
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
    Integer preNum = null;
    public int minDiffInBST(TreeNode root) {
        int res = Integer.MAX_VALUE;

        if(root.left != null){
            res = minDiffInBST(root.left);
        }

        if(preNum != null){
            res = Math.min(res, root.val - preNum);
        }
        preNum = root.val;

        if(root.right != null){
            res = Math.min(minDiffInBST(root.right), res);
        }

        return res;
    }
}
