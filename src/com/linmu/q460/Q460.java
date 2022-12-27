package com.linmu.q460;

/**
 * @author by lijun
 * @since 2022/11/29 14:48
 */
public class Q460 {
    public static void main(String[] args) {

    }
}

class LFUCache {



    public LFUCache(int capacity) {

    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {

    }

    class Node {
        int key;
        int val;
        int times;
        Node pre;
        Node next;

        public Node(int key, int val, int times, Node pre, Node next) {
            this.key = key;
            this.val = val;
            this.times = times;
            this.pre = pre;
            this.next = next;
        }
    }
}


