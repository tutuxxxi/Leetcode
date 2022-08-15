package com.linmu.q1282;

import java.util.*;

public class Q1282 {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int index = 0; index < groupSizes.length; index++) {
            int size = groupSizes[index];
            map.putIfAbsent(size, new ArrayList<>());
            List<Integer> orDefault = map.get(size);
            orDefault.add(index);
            if(orDefault.size() == size) {
                map.remove(size);
                ans.add(orDefault);
            }
        }
        return ans;
    }
}
