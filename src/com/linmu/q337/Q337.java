package com.linmu.q337;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q337 {
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
//    public int rob(TreeNode root) {
//        return util(root, true);
//    }
//
//
//    public int util(TreeNode root, boolean mark){
//
//        if(root == null)
//            return 0;
//
        //递归处存在缺点： 进行了多次计算递归，下面的优化可以一次调用计算两个值
//        if(mark){
//            return Math.max(
//                    root.val + util(root.left, false) + util(root.right, false),
//                    util(root.left, true) + util(root.right, true)
//            );
//        }else
//            return util(root.left, true) + util(root.right, true);
//    }


    public int rob(TreeNode root) {
        int[] num = getNum(root);
        return Math.max(num[0], num[1]);
    }

    //获取当前点的选取值和不选值
    public int[] getNum(TreeNode root){
        //为空节点时不存在值
        if(root == null){
            return new int[]{0,0};
        }

        int[] leftNum = getNum(root.left);
        int[] rightNum = getNum(root.right);

        //选取当前值时只能有两子树不选， 不选时应该取子树最大值
        return new int[]{
                root.val + leftNum[1] + rightNum[1],
                Math.max(leftNum[0], leftNum[1]) + Math.max(rightNum[0], rightNum[1])
        };
    }
}
