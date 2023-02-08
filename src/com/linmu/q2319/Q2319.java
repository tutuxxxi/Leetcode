package com.linmu.q2319;

/**
 * @author by lijun
 * @since 2023/1/31 9:04
 */
public class Q2319 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int length = grid.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int val = grid[i][j];
                if (i == j || i + j == length) {
                    if (val == 0) {
                        return false;
                    }
                } else if (val != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
