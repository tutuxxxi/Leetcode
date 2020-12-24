package com.linmu.q861;

import java.util.Arrays;

public class Q861 {
    public static void main(String[] args) {
        int i = new Solution().matrixScore(new int[][]{
                {0, 0, 1, 1},
                {0, 0, 1, 0},
                {0, 1, 0, 0}
        });
        System.out.println(i);
    }
}

//class Solution {
//    public int matrixScore(int[][] A) {
//
//        //对每一行，如果行首不为1，则翻转行
//        for(int[] row : A){
//            if(row[0] != 1){
//                for(int i = 0; i<row.length; i++){
//                    row[i] = row[i] == 1 ? 0 : 1;
//                }
//            }
//        }
//
//        //对每一列，如果该列1少于0，则翻转
//        for(int col = 0; col<A[0].length; col++){
//            int num0 = 0;
//            int num1 = 0;
//
//            for(int row = 0 ; row < A.length; row++){
//                if(A[row][col] == 0)
//                    num0++;
//                else
//                    num1++;
//            }
//
//            if(num0 > num1){
//                //翻转
//                for(int row = 0 ; row < A.length; row++){
//                    A[row][col] = A[row][col] == 0 ? 1 : 0;
//                }
//            }
//        }
//
//        //矩阵转化为数字
//        int count = 0;
//        int width = A[0].length;
//        for(int[] row : A){
//            for(int index = 0; index < width; index++){
//                count += row[index] * (int)Math.pow(2, width-index-1);
//            }
//        }
//
//        return count;
//    }
//}


class Solution {
    public int matrixScore(int[][] A) {

        //计算值
        int count = 0;

        int width = A[0].length;
        int height = A.length;

        //对每一行，如果行首不为1，则翻转行
        for(int[] row : A){
            if(row[0] != 1){
                for(int i = 1; i<width; i++){
                    row[i] = row[i] == 1 ? 0 : 1;
                }
            }
        }

        //此时第一列必定全都是1 先把值加上
        count += A.length * Math.pow(2, width - 1);


        //对每一列，如果该列1少于0，则翻转
        for(int col = 1; col < width; col++){
            int num0 = 0;

            for(int row = 0 ; row < height; row++){
                if(A[row][col] == 0)
                    num0++;
            }

            num0 = Math.max(num0, height-num0);

            //此时并不需要真正的翻转，只需要计算即可
            count += num0 * Math.pow(2, width - 1 - col);

        }

        return count;
    }
}
