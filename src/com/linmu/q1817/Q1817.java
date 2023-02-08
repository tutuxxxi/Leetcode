package com.linmu.q1817;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * @author by lijun
 * @since 2023/1/20 13:09
 */
public class Q1817 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] log : logs) {
            map.computeIfAbsent(log[0], integer -> new HashSet<>());
            map.get(log[0]).add(log[1]);
        }
        int[] ans = new int[k];
        map.forEach((key, value) -> ans[value.size() - 1]++);
        return ans;
    }
}
