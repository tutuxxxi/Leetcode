package com.linmu.q2349;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author by lijun
 * @since 2023/1/31 10:23
 */
public class Q2349 {
    public static void main(String[] args) {

    }
}

class NumberContainers {

    Map<Integer, Integer> indexNumMap = new HashMap<>(16);

    Map<Integer, TreeSet<Integer>> numIndexMap = new HashMap<>(16);

    public void change(int index, int number) {
        Integer integer = indexNumMap.get(index);
        if(integer != null) {
            numIndexMap.get(integer).remove(index);
        }
        indexNumMap.put(index, number);
        numIndexMap.computeIfAbsent(number, n -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        TreeSet<Integer> integers = numIndexMap.get(number);
        if(integers == null || integers.isEmpty()) {
            return -1;
        }
        return integers.first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
