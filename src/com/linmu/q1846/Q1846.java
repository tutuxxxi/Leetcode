package com.linmu.q1846;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/15 9:03 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1846 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] cnt = new int[n + 1];
        for (int v : arr) {
            ++cnt[Math.min(v, n)];
        }
        int miss = 0;
        for (int i = 1; i <= n; ++i) {
            if (cnt[i] == 0) {
                ++miss;
            } else {
                miss -= Math.min(cnt[i] - 1, miss);
            }
        }
        return n - miss;
    }
}
