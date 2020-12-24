package com.linmu.q122;

public class Q122 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{
                7,1,5,3,6,4
        }));
    }
}


class Solution {
    public int maxProfit(int[] prices) {
        /*
            解题思路：
                动态规划（将持有股票转换为持有负金额）

                定义数组dp为二维数组，其中x维度标示第x天，y表示当天是否持有股票
                    dp[2][0] : 第二天且不持有股票
                数组中的值表示此种情况下持有的最大金额

                则每一天的持有金额情况，都应该等于前一天的持有金额加上本天的交易（可能没有交易）
                    dp[x][0] = max ( dp[x-1][0], dp[x-1][1] + price[x] )
                    解释： 第x天不持有股票，拥有的最大金额要么等于前一天不持有股票拥有的最大金额  dp[x-1][0]
                                                   要么等于前一天持有股票，今天将股票出售后拥有的金额  dp[x-1][1] + price[x]

                    dp[x][1] = max ( dp[x-1][1], dp[x-1][0] - prices[x] )
                    解释： 第x天持有股票，拥有的最大金额要么等于前一天持有股票拥有的最大金额  dp[x-1][1]
                                                  要么等于前一天不持有股票，今天买入股票后的金额  dp[x-1][0] - price[x]
         */

        if(prices.length < 2)
            return 0;


        /*

        1、代码一： 常规dp

        int[][] dp = new int[prices.length][2];

        //第一天若不持有股票，金额为0； 若持有股票，金额为-prices[0]
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return dp[prices.length-1][0];
         */


        /*
        //由上面代码可见，dp数组并不是必须的

        2、内存优化dp

        int notHold = 0;
        int hold = -prices[0];
        int temp;

        for(int i = 1; i < prices.length; i++){
            temp = Math.max(notHold, hold + prices[i]);
            hold = Math.max(hold, notHold - prices[i]);

            notHold = temp;
        }

        return notHold;
         */






        /*
                题目为求序列中各个最大差值，可以使用贪心算法
                    因为仔细一想，如果第二天的价格小于今天，你一定不会在今天买入彩票，而是等到明天再买入
                    如果明天价格高于今天，你一定可以今天买入明天卖出，如果需要再在明天再次买入....

                因此得到结论，求最大收益既是得到数组中每两个相邻数的 正差值 的和
         */

        int count = 0;

        for(int i = 0; i<prices.length-1; i++){
            count += prices[i+1] > prices[i] ? prices[i+1] - prices[i] : 0;
        }
        return count;

    }
}