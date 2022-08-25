package com.linmu.q655;

import java.util.*;

/**
 * @author by lijun
 * @date 2022/8/22 8:32
 */
public class Q655 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);

        new Solution().printTree(root);
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
    public List<List<String>> printTree(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        int deep = 0, size;
        deque.offerLast(root);
        while((size = deque.size()) != 0) {
            deep++;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                if(treeNode.left != null) {
                    deque.offerLast(treeNode.left);
                }
                if(treeNode.right != null) {
                    deque.offerLast(treeNode.right);
                }
            }
        }

        int width = ((int) Math.pow(2, deep)) - 1;
        String[][] map = new String[deep][width];
        Deque<Integer> indexQueue = new LinkedList<>();
        for (int x = 0; x < map.length; x++) {
            Arrays.fill(map[x], "");
        }
        deep = 0;
        deque.offerLast(root);
        indexQueue.offerLast(0);
        while((size = deque.size()) != 0) {
            deep++;
            int totalSize = (int) Math.pow(2, deep - 1);
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                Integer index = indexQueue.pollFirst();
                map[deep - 1][getIndex(width, index, totalSize)] = Integer.toString(treeNode.val);

                if(treeNode.left != null) {
                    deque.offerLast(treeNode.left);
                    indexQueue.offerLast(index * 2);
                }
                if(treeNode.right != null) {
                    deque.offerLast(treeNode.right);
                    indexQueue.offerLast(index * 2 + 1);
                }
            }
        }

        List<List<String>> ans = new ArrayList<>(map.length);
        for (int x = 0; x < map.length; x++) {
            List<String> strings = new ArrayList<>(width);
            for (int y = 0; y < width; y++) {
                strings.add(map[x][y]);
            }
            ans.add(strings);
        }
        return ans;
    }


    /**
     * 通过长度及顺序序号获取数组中位置index
     * @param length
     * @param indexNum 从0开始
     * @param totalSize
     * @return
     */
    public static int getIndex(int length, int indexNum, int totalSize) {
        // 每一个元素占有位置大小
        int width = (length - totalSize + 1) / totalSize;
        return (width * indexNum) + indexNum + (width / 2);
    }
}
