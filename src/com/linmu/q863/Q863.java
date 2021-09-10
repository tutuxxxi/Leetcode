package com.linmu.q863;

import org.w3c.dom.Node;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/28 8:34 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q863 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(5);
//        root.left.left = new TreeNode(6);
//        root.left.right = new TreeNode(2);
//        root.left.right.left = new TreeNode(7);
//        root.left.right.right = new TreeNode(4);
//
//        root.right = new TreeNode(1);
//        root.right.left = new TreeNode(0);
//        root.right.right = new TreeNode(8);

        System.out.println(new Solution().distanceK(root, root, 3));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Deque<List<TreeNode>> stack = new ArrayDeque<>();

        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        stack.push(list);

        if(target == root){
            return getNodes(root, k);
        }

        break_point: while(true){
            List<TreeNode> peek = stack.peek();
            List<TreeNode> temp = new ArrayList<>();

            for(TreeNode node : peek){
                if(node.left != null){ temp.add(node.left); }
                if(node.right != null){ temp.add(node.right); }
                if(node.left == target || node.right == target){ break break_point; }
            }
            stack.push(temp);
        }

        List<Integer> res = new ArrayList<>();

        // 获取当前结点
        res.addAll(getNodes(target, k));

        while(!stack.isEmpty() && k != -1){
            // 找到父级结点
            List<TreeNode> pop = stack.pop();
            TreeNode parent = null;
            for(TreeNode node : pop){
                if(node.left == target || node.right == target){
                    parent = node;
                    break;
                }
            }

            if(parent.left == target){
                parent.left = null;
            }else{
                parent.right = null;
            }

            k--;
            target = parent;
            res.addAll(getNodes(target, k));
        }

        return res;
    }


    /**
     * 获取 root树下所有距离为k的结点
     * @param root
     * @param k
     * @return
     */
    public List<Integer> getNodes(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();

        if(root != null){
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);

            while(!queue.isEmpty() && k != 0){
                k--;

                int size = queue.size();
                for(int i = 0; i<size; i++){
                    TreeNode poll = queue.poll();
                    if(poll.left != null){
                        queue.offer(poll.left);
                    }
                    if(poll.right != null){
                        queue.offer(poll.right);
                    }
                }
            }

            if(k == 0){
                while(!queue.isEmpty()){
                    res.add(queue.poll().val);
                }
            }
        }

        return res;
    }
}
