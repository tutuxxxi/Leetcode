package com.linmu.q138;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/22 8:41 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q138 {
    public static void main(String[] args) {

    }
}


// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        // 存储每一个需要的node hashcode， 等到实例化时进行赋值
        Map<String, Node> map = new HashMap<>();
        Node res = new Node(-1);
        Node temp = res;

        while(head != null){
            Node node = new Node(head.val);
            node.random = head.random;

            // 存入
            map.put(head.toString(), node);

            temp.next = node;
            temp = temp.next;
            head = head.next;
        }

        temp = res.next;
        while (temp != null){
            if(temp.random != null){
                temp.random = map.get(temp.random.toString());
            }
            temp = temp.next;
        }

        return res.next;
    }
}
