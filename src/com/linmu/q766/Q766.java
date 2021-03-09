package com.linmu.q766;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/22 10:49
 * @description：leetcode q766
 * @modified By：
 * @version: 1.0
 */
public class Q766 {
    public static void main(String[] args) {
        new Solution().isToeplitzMatrix(new int[][]{
                {11,74,0,93},
                {40,11,74,7}
        });
    }
}


class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;

        boolean[][] mark = new boolean[height][width];

        for(int i = height - 1; i >= 0; i--){
            for(int j = width - 1; j >= 0; j--){
                //倒序开始检索

                if(i == height - 1 || j == width - 1){
                    //此时此位置必定构成托普利茨矩阵
                    mark[i][j] = true;
                }else{
                    if(matrix[i][j] == matrix[i+1][j+1] && mark[i+1][j+1] == true && mark[i][j+1] && mark[i+1][j]){
                        mark[i][j] = true;
                    }else{
                        mark[i][j] = false;
                    }
                }
            }
        }

        return mark[0][0];
    }
}