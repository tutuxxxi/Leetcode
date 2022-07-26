package com.linmu.q105;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/18 1:40 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q105 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buildTree(new int[]{1,2,3,4,5}, new int[]{1,2,3,4,5});
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, preorder.length);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int index1, int index2, int length) {
        if(length > 0) {
            TreeNode treeNode = new TreeNode(preorder[index1]);

            if(length > 1) {
                int newLength = -1;
                for(int i = 0; i<length; i++) {
                    if(inorder[index2 + i] == preorder[index1]) {
                        newLength = i;
                        break;
                    }
                }

                treeNode.left = buildTree(preorder, inorder, index1 + 1, index2, newLength);
                treeNode.right = buildTree(preorder, inorder, index1 + 1 + newLength, index2 + 1 + newLength, length - newLength - 1);
            }

            return treeNode;
        }
        return null;
    }
}
