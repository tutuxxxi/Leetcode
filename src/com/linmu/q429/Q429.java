package com.linmu.q429;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by lijun
 * @date 2022/8/25 17:22
 */
public class Q429 {
    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        if(root != null) {
            deque.offerLast(root);
        }
        int size;
        while((size = deque.size()) != 0) {
            List<Integer> nums = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                Node node = deque.pollFirst();
                nums.add(node.val);
                if(node.children != null && !node.children.isEmpty()) {
                    deque.addAll(node.children);
                }
            }
            ans.add(nums);
        }
        return ans;
    }
}
