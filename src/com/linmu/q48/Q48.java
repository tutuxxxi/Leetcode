package com.linmu.q48;

public class Q48 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        new Solution().rotate(arr);
    }
}


class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;

        //代表层数，从外往里，需要翻转的共有matrix.length/2层
        for(int t = 0; t < length/2; t++){
            //代表每一层遍历的位置， 起始位置一定是和层数相同，结束位置为长度减去层数
            for(int index = t; index < length - t - 1; index++){
                int temp = matrix[t][index];
                matrix[t][index] = matrix[length - index - 1][t];
                matrix[length - index - 1][t] = matrix[length - t - 1][length - index - 1];
                matrix[length - t - 1][length - index - 1] = matrix[index][length - t - 1];
                matrix[index][length - t - 1] = temp;
            }
        }
    }
}