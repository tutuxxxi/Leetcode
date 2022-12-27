package com.linmu.q895;

import java.util.*;

/**
 * @author by lijun
 * @since 2022/11/30 10:56
 */
public class Q895 {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
    }
}

class FreqStack {

    private final Map<Integer, Deque<Integer>> map;

    private int index;


    public FreqStack() {
        map = new HashMap<>();
        index = 0;
    }
}
