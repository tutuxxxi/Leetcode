package com.linmu.q106;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/18 3:26 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q106 {
    public static void main(String[] args) {
        new Solution().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(postorder, inorder, 0, 0, postorder.length);
    }


    public TreeNode buildTree(int[] postorder, int[] inorder, int index1, int index2, int length) {
        if(length > 0) {
            TreeNode treeNode = new TreeNode(postorder[index1 + length - 1]);

            if(length > 1) {
                int newLength = -1;
                for(int i = 0; i<length; i++) {
                    if(inorder[index2 + i] == postorder[index1 + length - 1]) {
                        newLength = i;
                        break;
                    }
                }

                treeNode.left = buildTree(postorder, inorder, index1, index2, newLength);
                treeNode.right = buildTree(postorder, inorder, index1 + newLength, index2 + newLength + 1, length - newLength - 1);
            }

            return treeNode;
        }
        return null;
    }
}
