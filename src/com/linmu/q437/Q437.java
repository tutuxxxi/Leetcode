package com.linmu.q437;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/28 8:42 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q437 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1000000000);
        treeNode.left = new TreeNode(1000000000);
        treeNode.left.left = new TreeNode(1000000000);
        treeNode.left.left.left = new TreeNode(-1000000000);
        treeNode.left.left.left.left = new TreeNode(-1000000000);
        treeNode.left.left.left.left.left = new TreeNode(-1000000000);

        System.out.println(new Solution().pathSum(treeNode, 0));
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
    LinkedList<Integer> list = new LinkedList<>();
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        list.add(0);
        dfs(root, targetSum);
        return res;
    }

    public void dfs(TreeNode root, int targetSum) {
        if(root != null) {
            int current = root.val + list.getLast();

            int finalCurrent = current;
            list.forEach(num -> {
                if(finalCurrent - num == targetSum) {
                    res++;
                }
            });

            list.addLast(current);
            dfs(root.left, targetSum);
            dfs(root.right, targetSum);
            list.removeLast();
        }
    }
}
