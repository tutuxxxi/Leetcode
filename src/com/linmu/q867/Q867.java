package com.linmu.q867;

import java.util.Arrays;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/25 10:30
 * @description：
 * @modified By：
 * @version:
 */
public class Q867 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int[][] res = new int[n][m];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
