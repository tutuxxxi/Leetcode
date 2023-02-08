package com.linmu.q1551;

/**
 * @author by lijun
 * @since 2023/1/9 10:25
 */
public class Q1551 {
    public static void main(String[] args) {
        int ans = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println((ans += (2 * i) + 1) + " - " + (i + 1) * (1 + (2 * i) + 1) / 2 + " - " + new Solution().minOperations(i + 1));
        }
    }
}

class Solution {
    public int minOperations(int n) {
        int sum = n * (2 + (2 * (n - 1))) / 2;
        int avg = sum / n;
        int num = n / 2;
        int ans = 0;

        for (int i = 0; i < num; i++) {
            int currentNum = (2 * i) + 1;
            ans += avg - currentNum;
        }
        return ans;
    }
}
