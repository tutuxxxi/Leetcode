package com.linmu.q103;

import java.util.*;

public class Q103 {
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();

        //是否翻转
        boolean mark = true;

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                tempList.add(temp.val);

                if (temp.left != null){
                    queue.offer(temp.left);
                }

                if (temp.right != null){
                    queue.offer(temp.right);
                }
            }

            if (mark){
                Collections.reverse(tempList);
            }
            list.add(tempList);
            mark = !mark;
        }

        return list;
    }
}