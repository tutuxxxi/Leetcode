package com.linmu.q1742;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by lijun
 * @since 2022/11/23 19:28
 */
public class Q1742 {
    public static void main(String[] args) {
        new Solution().countBalls(1, 10);
    }
}

class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int num = getNum(i);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getValue();
    }

    public static int getNum(int number) {
        int res = 0;
        while(number != 0) {
            res += number % 10;
            number /= 10;
        }
        return res;
    }
}
