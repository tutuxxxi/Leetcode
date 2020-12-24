package com.linmu.q463;

public class Q463 {
    public static void main(String[] args) {
        System.out.println(new Solution().islandPerimeter(new int[][]{
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        }));
    }
}


class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1){
                    if (i == 0 || grid[i-1][j] == 0)
                        count++;

                    if (i == grid.length-1 || grid[i+1][j] == 0)
                        count++;

                    if (j == 0 || grid[i][j-1] == 0)
                        count++;

                    if (j == grid[i].length-1 || grid[i][j+1] == 0)
                        count++;
                }
            }
        }

        return count;
    }
}
