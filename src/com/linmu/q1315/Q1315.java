package com.linmu.q1315;

public class Q1315 {
    public static void main(String[] args) {

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null)
            return 0;

        int count = 0;
        if(root.val % 2 == 0){
            if(root.left != null){
                if(root.left.left != null)
                    count += root.left.left.val;
                if(root.left.right != null)
                    count += root.left.right.val;
            }

            if(root.right != null){
                if(root.right.left != null)
                    count += root.right.left.val;
                if(root.right.right != null)
                    count += root.right.right.val;
            }
        }

        return count + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }
}
