package com.linmu.q926;

/**
 * @author ：xxx_
 * @date ：Created in 2022/6/11 15:34
 * @description：
 * @modified By：
 * @version:
 */
public class Q926 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minFlipsMonoIncr(String s) {
        // dp[i][0]: 第i位变为0且向前构成单调递增所需要的总次数
        // dp[i][1]: 第i位变为1且向前构成单调递增所需要的总次数
        // dp[i][0] = dp[i - 1][0] + (s[i] == '1' ? 1 : 0)
        // dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (s[i] == '1' ? 1 : 0)

        int length = s.length();
        int[][] dp = new int[length][2];

        // 初始化
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = dp[0][0] == 0 ? 1 : 0;

        // dp
        for (int i = 1; i < length; i++) {
            dp[i][0] = dp[i - 1][0] + (s.charAt(i) == '1' ? 1 : 0);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (s.charAt(i) == '0' ? 1 : 0);
        }

        return Math.min(dp[length - 1][0], dp[length - 1][1]);
    }


    public int minFlipsMonoIncr2(String s) {
        // dp[i] 只与dp[i - 1]有关 降低空间复杂度

        int length = s.length();
        int dp1, dp2;

        // 初始化
        dp1 = s.charAt(0) == '0' ? 0 : 1;
        dp2 = dp1 == 0 ? 1 : 0;

        // dp
        for (int i = 1; i < length; i++) {
            dp2 = Math.min(dp1, dp2) + (s.charAt(i) == '0' ? 1 : 0);
            dp1 = dp1 + (s.charAt(i) == '1' ? 1 : 0);
        }

        return Math.min(dp1, dp2);
    }
}
