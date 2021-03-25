package com.linmu.q73;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/21 8:11 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q73 {
    public static void main(String[] args) {

    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }

        boolean[][] marks = {
                new boolean[matrix.length],
                new boolean[matrix[0].length]
        };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    marks[0][i] = true;
                    marks[1][j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(marks[0][i] || marks[1][j]){
                    matrix[i][j] = 0;
                }
            }
        }


    }
}
