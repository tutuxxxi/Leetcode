package com.linmu.q2428;

/**
 * @author by lijun
 * @since 2023/2/1 9:01
 */
public class Q2428 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int max = Integer.MIN_VALUE;

        for (int x = 0; x < height - 2; x++) {
            // 获取第一个沙漏值
            int sum = grid[x][0] + grid[x][1] + grid[x][2] + grid[x + 1][1] + grid[x + 2][0] + grid[x + 2][1] + grid[x + 2][2];
            max = Math.max(max, sum);

            for (int y = 1; y < width - 2; y++) {
                // 向右移动一步
                sum = sum - grid[x][y - 1] + grid[x][y + 2] - grid[x + 1][y] + grid[x + 1][y + 1] - grid[x + 2][y - 1] + grid[x + 2][y + 2];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
