package com.linmu.q1803;

import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderImpl;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author by lijun
 * @since 2023/1/5 17:19
 */
public class Q1803 {
    public static void main(String[] args) {
//        new Solution().countPairs();
    }
}


class Solution {
    public int countPairs(int[] nums, int low, int high) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }


        List<Integer> keys = new ArrayList<>(count.keySet());
        int keySize = keys.size();
        int ans = 0;
        for (int i = 0; i < keySize; i++) {
            Integer num1 = keys.get(i);
            Integer size = count.get(num1);
            for (int j = i + 1; j < keySize; j++) {
                Integer num2 = keys.get(j);
                int res = num1 ^ num2;
                if(res >= low && res <= high) {
                    ans += size * count.get(num2);
                }
            }
        }
        return ans;
    }
}
