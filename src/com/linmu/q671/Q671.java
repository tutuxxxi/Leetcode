package com.linmu.q671;

import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/27 8:44 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q671 {
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

    public int findSecondMinimumValue(TreeNode root) {
        return findSecondMinimumValue(root, root.val);
    }

    public int findSecondMinimumValue(TreeNode root, int target) {
        if(root == null){
            return -1;
        }

        if(root.val > target){
            return root.val;
        }

        int left = findSecondMinimumValue(root.left, target);
        int right = findSecondMinimumValue(root.right, target);

        // 符号相等返回小值，否则大zhi
        if(left * right > 0){
            return Math.min(left, right);
        }else{
            return Math.max(left, right);
        }
    }
}
