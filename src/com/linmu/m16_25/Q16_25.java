package com.linmu.m16_25;

public class Q16_25 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 1 /* 缓存容量 */ );

        cache.get(2);
        cache.get(2);
        cache.put(2,6);
        cache.get(1);
        cache.put(1,5);
        cache.put(1,2);
    }
}


class LRUCache {

    private int capacity;

    private int length;

    private LinkNode head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        length = 0;
        head = null;
    }

    public int get(int key) {
        LinkNode temp = head;

        if(head == null)
            return -1;

        if(head.key == key)
            return head.value;


        while(temp != null && temp.next != null){
            if(temp.next.key == key){

                //找到该节点，将它放到队首
                LinkNode temp2 = temp.next;
                temp.next = temp.next.next;
                temp2.next = head;
                head = temp2;

                return head.value;
            }
            else
                temp = temp.next;
        }

        return -1;
    }

    public void put(int key, int value) {
        if(get(key) != -1){
            head.value = value;
        }else{
            LinkNode temp = new LinkNode(key, value, head);
            head = temp;
            length++;

            if(length > capacity){
                //去除末尾
                while(temp.next.next != null){
                    temp = temp.next;
                }

                temp.next = null;
            }
        }
    }

    private class LinkNode{
        int key;
        int value;
        LinkNode next;

        public LinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public LinkNode(int key, int value, LinkNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
