package com.linmu.q1049;

import java.util.Arrays;

/**
 * @author ：xxx_
 * @date ：Created in 2021/6/8 9:11 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1049 {
    public static void main(String[] args) {
        System.out.println(new Solution().lastStoneWeightII(new int[]{2}));
    }
}

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = Arrays.stream(stones).sum();
        int cap = sum/2;

        int dp[] = new int[cap+1];
        for(int i=0;i<n;i++){
            //内层倒序遍历
            for(int j=cap;j>=stones[i];j--){
                dp[j] = Math.max(dp[j],dp[j-stones[i]] + stones[i]);
            }
        }
        return sum-dp[cap]*2;
    }
}
