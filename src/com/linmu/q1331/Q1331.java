package com.linmu.q1331;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ：xxx_
 * @date ：Created in 2022/7/28 9:07
 * @description：
 * @modified By：
 * @version:
 */
public class Q1331 {
    public static void main(String[] args) {
        new Solution().arrayRankTransform(new int[]{40,10,20,30});
    }
}

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, LinkedList<Integer>> map = new TreeMap<>();
        for (int index = 0; index < arr.length; index++) {
            LinkedList<Integer> orDefault = map.getOrDefault(arr[index], new LinkedList<>());
            orDefault.add(index);
            map.put(arr[index], orDefault);
        }

        int count = 1;
        for (Map.Entry<Integer, LinkedList<Integer>> entry : map.entrySet()) {
            LinkedList<Integer> value = entry.getValue();
            for (Integer integer : value) {
                arr[integer] = count;
            }
            count++;
        }
        return arr;
    }
}
