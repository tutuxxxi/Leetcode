package com.linmu.q1145;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author by lijun
 * @date 2022/8/16 17:08
 */
public class Q1145 {
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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // 只需要获取被选中节点的左子树大小、右子树大小和其他节点大小，即可得到是否有绝杀的机会
        TreeNode node = findNode(root, x);
        int leftSize = getTreeSize(node.left, null);
        int rightSize = getTreeSize(node.right, null);
        int exceptSize = getTreeSize(root, node);
        return leftSize > (rightSize + exceptSize + 1) || rightSize > (leftSize + exceptSize + 1)
                || exceptSize > (leftSize + rightSize + 1);
    }

    /**
     * 获取树中节点个数
     *
     * @param treeNode
     * @return
     */
    public int getTreeSize(TreeNode treeNode, TreeNode except) {
        int count = 0;
        if(treeNode != null) {
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offerLast(treeNode);

            while(!deque.isEmpty()) {
                TreeNode headNode = deque.pollFirst();
                if(headNode != except) {
                    count++;
                    if(headNode.left != null) {
                        deque.offerLast(headNode.left);
                    }
                    if(headNode.right != null) {
                        deque.offerLast(headNode.right);
                    }
                }
            }
        }
        return count;
    }


    public TreeNode findNode(TreeNode treeNode, int value) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(treeNode);
        int size = 0;
        while((size = deque.size()) != 0) {
            for (int i = 0; i < size; i++) {
                TreeNode treeNode1 = deque.pollFirst();
                if(treeNode1.val == value) {
                    return treeNode1;
                }
                if(treeNode1.left != null) {
                    deque.offerLast(treeNode1.left);
                }
                if(treeNode1.right != null) {
                    deque.offerLast(treeNode1.right);
                }
            }
        }
        return null;
    }
}
