package com.linmu.q304;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/2 10:29
 * @description：
 * @modified By：
 * @version:
 */
public class Q304 {
    public static void main(String[] args) {
        NumMatrix matrix = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });

        matrix.sumRegion(2, 1, 4, 3);
    }
}

/*         简单遍历写法


class NumMatrix {

    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

public int sumRegion(int row1, int col1, int row2, int col2) {
    int res = 0;
    for(; row1 <= row2; row1++){
        for(int i = col1; i <= col2; i++){
            res += matrix[row1][i];
        }
    }
    return res;
}
}



*/


/**
 * 前缀和
 */
class NumMatrix {

    // matrix数组用于储存前缀和
    private int[][] mat;

    public NumMatrix(int[][] matrix) {
        mat = matrix;

        for(int i = 0; i<mat.length; i++){
            for (int j = 0; j<mat[0].length; j++){
                if(i != 0){
                    mat[i][j] += mat[i-1][j];
                }

                if(j != 0){
                    mat[i][j] += mat[i][j-1];
                }

                if(i != 0 && j != 0){
                    mat[i][j] -= mat[i-1][j-1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = mat[row2][col2];

        if(row1 != 0){
            res -= mat[row1-1][col2];
        }

        if(col1 != 0){
            res -= mat[row2][col1-1];
        }

        if(row1 != 0 && col1 != 0){
            res += mat[row1-1][col1-1];
        }

        return res;
    }
}




