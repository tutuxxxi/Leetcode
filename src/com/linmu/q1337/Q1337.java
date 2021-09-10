package com.linmu.q1337;

import java.util.*;
import java.util.function.Function;

/**
 * @author ：xxx_
 * @date ：Created in 2021/8/5 4:53 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1337 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Arrays.stream(mat).forEach(ma -> map.put(map.size(), Arrays.stream(ma).sum()));
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Comparator.comparingInt(Map.Entry::getValue));

        int[] res = new int[k];
        for(int i = 0; i<res.length; i++){
            res[i] = list.get(i).getKey();
        }
        return res;
    }
}
