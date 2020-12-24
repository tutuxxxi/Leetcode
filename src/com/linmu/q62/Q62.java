package com.linmu.q62;

import java.util.Arrays;

public class Q62 {
    public static void main(String[] args) {
        new Solution().uniquePaths(10, 10);
    }
}

class Solution {
    public int uniquePaths(int m, int n) {

        //low bi 的动态规划

//        int[][] dp = new int[n][m];
//
//        Arrays.fill(dp[0], 1);
//        for(int i = 1; i < n; i++){
//            dp[i][0] = 1;
//        }
//
//        for(int i = 1; i<n; i++){
//            for(int j = 1; j<m; j++){
//                dp[i][j] = dp[i-1][j] + dp[i][j-1];
//            }
//        }
//        return dp[n-1][m-1];


        //高手的排列组合

        int x = Math.min(m, n) - 1;
        int y = m + n - 2;

        if(x == 0)
            return 1;
        //阶乘计算

        double countX = x;
        for(int i = x-1; i>1; i--)
            countX *= i;

        double countY = y;
        for(int i = x-1; i>0; i--)
            countY *= --y;


        return (int) (countY/countX);
    }
}
