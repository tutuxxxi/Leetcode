package com.linmu.q958;

import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author by lijun
 * @date 2022/8/15 10:07
 */
public class Q958 {
    public static void main(String[] args) {
        /*
        1
        2 3
        4 5 6 7
        8 9 10 11 12 13 14 15
        16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31
        32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56b 57 58 59 60 61 62 63
        64
         */
        TreeNode root = new TreeNode(1);
        int target = 34, count = 2;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while(true) {
            TreeNode treeNode = deque.pollFirst();
            if(count == target) {
                break;
            }
            treeNode.left = new TreeNode(count++);
            deque.offerLast(treeNode.left);


            if(count == target) {
                break;
            }
            treeNode.right = new TreeNode(count++);
            deque.offerLast(treeNode.right);
        }

        System.out.println(new Solution().isCompleteTree(root));
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
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        int size, shouldSize = 1;
        while((size = deque.size()) != 0) {
            boolean canHaveChildren = shouldSize == size;
            for (int i = 0; i < size; i++) {
                TreeNode first = deque.pollFirst();

                if(first.left == null) {
                    if(first.right != null) {
                        return false;
                    }else {
                        canHaveChildren = false;
                    }
                }else {
                    if(!canHaveChildren) {
                        return false;
                    }else {
                        deque.offerLast(first.left);
                        if(first.right == null) {
                            canHaveChildren = false;
                        }else {
                            deque.offerLast(first.right);
                        }
                    }
                }
            }
            shouldSize *= 2;
        }
        return true;
    }
}
