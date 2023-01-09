package com.linmu.q2316;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author by lijun
 * @since 2022/12/29 10:24
 */
public class Q2316 {
    public static void main(String[] args) {
        new Solution().countPairs(3, new int[][]{
                {0, 1},
                {0, 2},
                {1, 2}
        });
    }
}


class Solution {
    public long countPairs(int n, int[][] edges) {
        Link link = new Link();
        for (int[] edge : edges) {

        }

        return 0L;
    }
}

class Link {

    Map<Integer, Integer> map = new HashMap<>();

    public void set(int num1, int num2) {
        map.put(num1, get(num2));
    }

    public int get(int num) {
        Integer value = map.get(num);
        if(value == null) {
            map.put(num, num);
            return num;
        }else if(value == num) {
            return value;
        }

        int newHead = get(value);
        if(newHead != value) {
            map.put(num, newHead);
        }
        return newHead;
    }

    public boolean contains(int num) {
        return map.containsKey(num);
    }

}
