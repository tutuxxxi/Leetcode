package com.linmu.o91;

/**
 * @author ：xxx_
 * @date ：Created in 2022/6/25 14:22
 * @description：
 * @modified By：
 * @version:
 */
public class O91 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minCost(int[][] costs) {
        int nums = costs.length;

        // dp[i][0]: 将第i间房子刷为0的最小花费
        int[][] dp = new int[nums][3];
        dp[0] = costs[0];

        for(int index = 1; index < nums; index++) {
            dp[index][0] = costs[index][0] + Math.min(dp[index - 1][1], dp[index - 1][2]);
            dp[index][1] = costs[index][1] + Math.min(dp[index - 1][0], dp[index - 1][2]);
            dp[index][2] = costs[index][2] + Math.min(dp[index - 1][1], dp[index - 1][0]);
        }

        return Math.min(Math.min(dp[nums - 1][0], dp[nums - 1][1]), dp[nums - 1][2]);
    }
}
