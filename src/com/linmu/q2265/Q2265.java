package com.linmu.q2265;

import java.util.*;
/**
 * @author by lijun
 * @since 2022/11/29 11:20
 */
public class Q2265 {
    public static void main(String[] args) {
        //[1,3,0,3]
        //   1
        //  3 0
        // 3
        TreeNode treeNode = new TreeNode(1, new TreeNode(3, new TreeNode(3), null), new TreeNode(0));
        System.out.println(new Solution().averageOfSubtree(treeNode));
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
    public int averageOfSubtree(TreeNode root) {
        // top排序
        Map<TreeNode, TreeNode> fatherMap = new HashMap<>();

        // 层次遍历初始化数据
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<Entity> startNodes = new ArrayDeque<>();
        deque.offer(root);

        while(!deque.isEmpty()) {
            TreeNode treeNode = deque.pollFirst();
            int income = 0;
            if(treeNode.left != null) {
                income++;
                fatherMap.put(treeNode.left, treeNode);
                deque.offerLast(treeNode.left);
            }
            if(treeNode.right != null) {
                income++;
                fatherMap.put(treeNode.right, treeNode);
                deque.offerLast(treeNode.right);
            }
            if(income == 0) {
                startNodes.offer(new Entity(treeNode, 0, 0));
            }
        }


        int ans = 0;
        Map<TreeNode, Entity> map = new HashMap<>();
        while(!startNodes.isEmpty()) {
            Entity entity = startNodes.pollFirst();
            if(((entity.node.val + entity.count) / (entity.num + 1)) == entity.node.val) {
                ans++;
            }

            TreeNode father = fatherMap.get(entity.node);
            if(father != null) {
                Entity fatherEntity = map.computeIfAbsent(father, t -> {
                    Entity e = new Entity(t, 0, 0);
                    startNodes.offerLast(e);
                    return e;
                });
                fatherEntity.num += (entity.num + 1);
                fatherEntity.count += entity.count + entity.node.val;
            }
        }
        return ans;
    }

    class Entity {
        TreeNode node;
        int count;
        int num;

        public Entity(TreeNode node, int count, int num) {
            this.node = node;
            this.count = count;
            this.num = num;
        }
    }
}
