package com.linmu.q1394;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by lijun
 * @since 2023/1/6 18:09
 */
public class Q1394 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey().equals(entry.getValue()) && entry.getKey() > ans) {
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
