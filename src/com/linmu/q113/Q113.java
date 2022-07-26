package com.linmu.q113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/18 4:00 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q113 {
    public static void main(String[] args) {
        new Solution().pathSum(new TreeNode(-2, null, new TreeNode(-3)), -5);
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
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSum(root, 0, targetSum);
        return res;
    }

    public void pathSum(TreeNode root, int current, int targetSum) {
        if(root != null) {
            current += root.val;
            list.addLast(root.val);

            if(current == targetSum && root.left == null && root.right == null) {
                res.add(new ArrayList<>(list));
            }else{
                pathSum(root.left, current, targetSum);
                pathSum(root.right, current, targetSum);
            }

            list.removeLast();
        }
    }
}
