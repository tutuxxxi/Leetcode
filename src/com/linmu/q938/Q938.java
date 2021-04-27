package com.linmu.q938;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/27 10:20 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q938 {
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
    private int res;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root != null){
            if(root.val > high){
                rangeSumBST(root.left, low, high);
            }else if(root.val < low){
                rangeSumBST(root.right, low, high);
            }else{
                res += root.val;
                rangeSumBST(root.left, low, high);
                rangeSumBST(root.right, low, high);
            }
        }

        return res;
    }
}
