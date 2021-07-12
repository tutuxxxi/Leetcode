package com.linmu.q279;

/**
 * @author ：xxx_
 * @date ：Created in 2021/6/11 11:24 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q279 {
    public static void main(String[] args) {
        new Solution().numSquares(12);
    }
}

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int max = (int)Math.sqrt(n);

        for(int i = 0; i<dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for(int i = 1; i<=max; i++){
            for(int j = i * i; j <= n; j++){
                dp[j] = Math.min(dp[j], dp[j - i*i] + 1);
            }
        }
        return dp[n];
    }
}
