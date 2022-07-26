package com.linmu.q96;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/17 2:37 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q96 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.numTrees(19);
        for(int i = 1; i < 19; i++) {
            System.out.println(solution.numTrees(i));
        }
    }
}


class Solution {
    public int numTrees(int n) {
        // n个数能构成的可能性
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < n + 1; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
