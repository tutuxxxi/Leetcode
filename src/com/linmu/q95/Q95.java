package com.linmu.q95;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/17 2:04 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q95 {
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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        return generateTrees(1, n);
    }

    /**
     * 获取从start到end的所有可能性
     * @param from
     * @param to
     * @return
     */
    private List<TreeNode> generateTrees(int from, int to) {
        List<TreeNode> res = new ArrayList<>();

        if(from >= to) {
            // 递归出口
            res.add(from == to ? new TreeNode(from) : null);
        }else {
            // 枚举每一个结点作为根
            for (int i = from; i <= to; i++) {
                // 左子树所有可能性
                List<TreeNode> leftTrees = generateTrees(from, i - 1);
                // 右子树所有可能性
                List<TreeNode> rightTrees = generateTrees(i + 1, to);

                // 左右可能性 全排列
                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        res.add(new TreeNode(i, leftTree, rightTree));
                    }
                }
            }
        }
        return res;
    }
}
