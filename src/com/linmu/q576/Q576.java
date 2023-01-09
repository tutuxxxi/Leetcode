package com.linmu.q576;

/**
 * @author by lijun
 * @since 2023/1/6 17:31
 */
public class Q576 {
    public static void main(String[] args) {
        new Solution().findPaths(1,3,3,0,1);
    }
}

class Solution {

    private static final int MOD = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // dp[x][y][n]: 从x,y开始，走n+1步能走出去的种类
        int[][][] dp = new int[m][n][maxMove];
        for (int i = 0; i < m; i++) {
            dp[i][0][0]++;
            dp[i][n-1][0]++;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i][0]++;
            dp[m-1][i][0]++;
        }

        for (int i = 1; i < maxMove; i++) {
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    // dp[x][y][i] = dp[x-1][y][i-1] + dp[x][y-1][i-1] + dp[x+1][y][i-1] + dp[x][y+1][i-1]
                    int sum = 0;
                    if(x > 0) {
                        sum = (sum + dp[x-1][y][i-1]) % MOD;
                    }
                    if(y > 0) {
                        sum = (sum + dp[x][y-1][i-1]) % MOD;
                    }
                    if(x < m - 1) {
                        sum = (sum + dp[x+1][y][i-1]) % MOD;
                    }
                    if(y < n - 1) {
                        sum = (sum + dp[x][y+1][i-1]) % MOD;
                    }
                    dp[x][y][i] = sum;
                }
            }
        }
        int ans = 0;
        for (int num : dp[startRow][startColumn]) {
            ans = (ans + num) % MOD;
        }
        return ans;
    }
}
