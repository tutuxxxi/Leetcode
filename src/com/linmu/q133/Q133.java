package com.linmu.q133;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/30 2:01 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q133 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        ArrayList<Node> list = new ArrayList<>();
        list.add(node2);
        list.add(node3);
        list.add(node4);
        node1.neighbors = list;

        list = new ArrayList<>();
        list.add(node5);
        list.add(node6);
        node2.neighbors = list;

        list = new ArrayList<>();
        list.add(node7);
        node3.neighbors = list;


        new Solution().cloneGraph(node1);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }

        Map<Node, Node> map = new HashMap<>();
        LinkedList<Node> deque = new LinkedList<>();

        while(!deque.isEmpty()) {
            Node tempNode = deque.removeFirst();
            if(!map.containsKey(tempNode)) {
                map.put(tempNode, new Node(tempNode.val, (ArrayList<Node>) tempNode.neighbors));
                if(tempNode.neighbors != null) {
                    deque.addAll(tempNode.neighbors);
                }
            }
        }

        deque.clear();
        node = map.get(node);
        deque.add(node);

        while(!deque.isEmpty()) {
            Node tempNode = deque.removeFirst();
            List<Node> neighbors = tempNode.neighbors;
            if(neighbors != null && !neighbors.isEmpty()) {
                List<Node> newNeighbors = new ArrayList<>();
                for (Node neighbor : neighbors) {
                    if(map.containsKey(neighbor)) {
                        Node n = map.get(neighbor);
                        newNeighbors.add(n);
                        deque.add(n);
                    }else{
                        newNeighbors.add(neighbor);
                    }
                }
                tempNode.neighbors = newNeighbors;
            }
        }
        return node;
    }
}
