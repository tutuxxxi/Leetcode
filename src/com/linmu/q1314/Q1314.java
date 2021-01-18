package com.linmu.q1314;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/15 4:55 下午
 * @description：leetcode q1314
 * @modified By：
 * @version: 1.0
 */
public class Q1314 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] res = new int[mat.length][mat[0].length];
        int count = 0;

        for(int col = 0; col < Math.min(mat.length, K); col++){
            for(int row = 1; row < Math.min(mat[0].length, K); row++){
                count += mat[col][row];
            }
        }
        res[0][0] = count;
        for(int col = 0; col < mat.length; col++){
            for(int row = 1; row < mat[0].length; row++){

            }
        }

        return res;
    }
}