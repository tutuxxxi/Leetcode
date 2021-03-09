package com.linmu.q832;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/24 13:04
 * @description：
 * @modified By：
 * @version:
 */
public class Q832 {
    public static void main(String[] args) {
        new Solution().flipAndInvertImage(new int[][]{
                {1,1,0},
                {1,0,1},
                {0,0,0}
        });
    }
}

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        //对每一行的两个对应位置遍历
        //只会存在以下情况：
        //两个位置的数字相同： 则都变为原来的相反数
        //两个位置的数字不同： 则都不变
        //仅为一个数字的直接变为相反数

        int width = A[0].length;

        if(width % 2 != 0){
            for(int i = 0; i < A.length; i++){
                A[i][width/2] = 1 - A[i][width/2];
            }
        }

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < width/2; j++) {
                if(A[i][j] == A[i][width-1-j]){
                    //两个相等则变为原来的相反数
                    A[i][j] = 1 - A[i][j];
                    A[i][width-1-j] = 1 - A[i][width-1-j];
                }
            }
        }

        return A;
    }
}
