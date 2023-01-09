package com.linmu.q2144;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author by lijun
 * @since 2022/12/27 15:56
 */
public class Q2144 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans = 0;
        int length = cost.length;
        for (int i = 1; i <= length; i++) {
            if(i % 3 != 0) {
                ans += cost[length - i];
            }
        }
        return ans;
    }
}

// 9 7 6 5 2 2

// 1
// 1 2
// 1 2 3
// 1 2 3 4 5 6 7
