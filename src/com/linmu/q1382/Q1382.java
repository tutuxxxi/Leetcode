package com.linmu.q1382;

import com.sun.media.sound.RIFFInvalidDataException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by lijun
 * @since 2023/1/31 14:38
 */
public class Q1382 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));
        System.out.println(new Solution().balanceBST(treeNode));
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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> data = new ArrayList<>();
        inOrder(root, data);

        // build
        return build(0, data.size() - 1, data);
    }

    private void inOrder(TreeNode root, List<Integer> data) {
        if(root != null) {
            inOrder(root.left, data);
            data.add(root.val);
            inOrder(root.right, data);
        }
    }

    private TreeNode build(int preIndex, int nextIndex, List<Integer> data) {
        if(preIndex > nextIndex) {
            return null;
        }

        int center = (preIndex + nextIndex) / 2;
        TreeNode node = new TreeNode();
        node.val = data.get(center);
        node.left = build(preIndex, center - 1, data);
        node.right = build(center + 1, nextIndex, data);
        return node;
    }
}
