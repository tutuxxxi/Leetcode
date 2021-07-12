package com.linmu.q518;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xxx_
 * @date ：Created in 2021/6/10 8:26 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q518 {
    public static void main(String[] args) {
        new Solution().change(5, new int[]{1,2,5});
    }
}

class Solution {
    public int change(int amount, int[] coins) {

        //dp[i]: 凑i元拥有的方案数
        int[] dp = new int[amount+1];

        dp[0] = 1;

        // 按顺序将硬币填入，避免了出现重复数据
        for(int coin : coins){
            for(int price = coin; price <= amount; price++){
                dp[price] += dp[price - coin];
            }
        }

        return dp[amount];
    }
}