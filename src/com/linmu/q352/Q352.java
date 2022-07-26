package com.linmu.q352;

import java.util.*;
import java.util.function.IntFunction;

/**
 * @author ：xxx_
 * @date ：Created in 2021/10/9 1:39 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q352 {
    public static void main(String[] args) {
        int[] a[] = new int[6][];
        int b[][] = new int[6][];
    }
}

class SummaryRanges1 {
    private TreeSet<Integer> set;

    public SummaryRanges1() {
        set = new TreeSet<>();
    }

    public void addNum(int val) {
        set.add(val);
    }

    public int[][] getIntervals() {
        List<int[]> list = new LinkedList<>();
        Integer startNum = null, preNum = null;

        if(!set.isEmpty()) {
            for (Integer integer : set) {
                if(startNum == null) {
                    startNum = integer;
                }else{
                    if(!preNum.equals(integer-1)) {
                        list.add(new int[]{startNum, preNum});
                        startNum = integer;
                    }
                }
                preNum = integer;
            }
            list.add(new int[]{startNum, preNum});
        }

        return list.toArray(new int[0][0]);
    }
}

class SummaryRanges {
    private TreeSet<int[]> set;

    public SummaryRanges() {
        set = new TreeSet<>((o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
    }

    public void addNum(int val) {
    }

    public int[][] getIntervals() {
        return null;
    }
}
