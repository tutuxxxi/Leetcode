package com.linmu.q706;

import javax.swing.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/14 9:27 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q706 {
    public static void main(String[] args) {
    }
}

class MyHashMap {

    class Node{
        public int key;
        public int value;

        public Node next;

        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node[] hashList;

    private final int base = 769;

    /** Initialize your data structure here. */
    public MyHashMap() {
        hashList = new Node[base];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % base;


        if(hashList[index] == null){
            hashList[index] = new Node(key, value, null);
        }else{
            Node target = hashList[index];

            while(target.next != null){
                if(target.key == key){
                    target.value = value;
                    return;
                }
                target = target.next;
            }

            if(target.key == key){
                target.value = value;
                return;
            }

            target.next = new Node(key, value, null);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % base;

        if(hashList[index] != null){
            Node temp = hashList[index];
            while(temp != null){
                if(temp.key == key){
                    return temp.value;
                }
                temp = temp.next;
            }
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % base;

        if(hashList[index] != null){

            if(hashList[index].key == key){
                hashList[index] = hashList[index].next;
            }else{

                Node preIndex = hashList[index];
                Node lastIndex = preIndex.next;

                while(lastIndex != null){
                    if(lastIndex.key == key){
                        preIndex.next = lastIndex.next;
                    }

                    preIndex = lastIndex;
                    lastIndex = lastIndex.next;
                }
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
