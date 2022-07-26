package com.linmu.q63;

import javax.jws.Oneway;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/13 10:37 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q63 {
    public static void main(String[] args) {
        new Solution().uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        });
    }
}

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        int[][] dp = new int[height][width];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for(int i = 1; i<width; i++) {
            if(obstacleGrid[0][i] == 0) {
                dp[0][i] = dp[0][i-1];
            }
        }

        for(int i = 1; i<height; i++) {
            if(obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i-1][0];
            }
        }

        for(int i = 1; i < height; i++) {
            for(int j = 1; j < width; j++) {
                if(obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[height-1][width-1];
    }
}
