package com.linmu.q222;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q222 {
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(5);
        TreeNode r7 = new TreeNode(7);
        TreeNode r8 = new TreeNode(8);
//        TreeNode r9 = new TreeNode(9);
//        TreeNode r10 = new TreeNode(10);
        r4.left = r8;
//        r4.right = r9;
//        r5.left = r10;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;
        r1.left = r2;
        r1.right = r3;

        System.out.println(new Solution().countNodes(r1));
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int countNodes(TreeNode root) {

        if(root == null)
            return 0;


        int size = 0;
        Stack<TreeNode> stack = new Stack<>();

        while(root != null){
            stack.push(root);
            size++;
            root = root.left;
        }

        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();

            if(!stack.isEmpty()){
                temp = stack.pop().right;
                if(temp == null){
                    //存入一个撑场面的值 并无实际意义
                    stack.push(new TreeNode(-1));
                }
            }else{
                if(temp.right != null)
                    temp = temp.right;
                else
                    return size;
            }

            while(temp != null){
                stack.push(temp);
                size++;
                temp = temp.left;
            }
        }

        return size;
    }
}
