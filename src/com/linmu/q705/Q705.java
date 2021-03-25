package com.linmu.q705;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/13 10:06 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q705 {
    public static void main(String[] args) {

    }
}

class MyHashSet {

    boolean[] mark;

    /** Initialize your data structure here. */
    public MyHashSet() {
        mark = new boolean[1000001];
    }

    public void add(int key) {
        mark[key] = true;
    }

    public void remove(int key) {
        mark[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return mark[key];
    }
}