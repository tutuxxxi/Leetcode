package com.linmu.q879;

/**
 * @author ：xxx_
 * @date ：Created in 2021/6/9 8:46 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q879 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

        // dp[i][j]: 剩余i个员工时创造j利润的方案数
        int[][] dp = new int[n+1][minProfit+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // 对每一个工作任务进行遍历
        for (int jobIndex = 0; jobIndex < group.length; jobIndex++) {

            // 完成这个任务时，人数最大为 n人，最小为group[jobIndex]人
            for (int personNum = n; personNum >= group[jobIndex]; personNum--) {

                // 完成这个任务时，能到达的利润最大为minProfit， 最小0
                for (int k = minProfit; k >= 0; k--) {
                    dp[personNum][k] = (dp[personNum][k] + dp[personNum - group[jobIndex]][Math.max(0, k - profit[jobIndex])]) % 1000000007;
                }
            }
        }

        return dp[n][minProfit];
    }
}