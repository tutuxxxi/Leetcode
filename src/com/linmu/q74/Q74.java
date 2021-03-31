package com.linmu.q74;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/30 10:24 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q74 {
    public static void main(String[] args) {
        new Solution().searchMatrix(new int[][]{
                {1,3,5,7}, {10,11,16,20},{23,30,34,60}
        }, 3);
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[m-1].length;

        //从最后一行开始检索
        int lastIndex = m - 1;

        if(matrix[lastIndex][n-1] < target){
            return false;
        }

        //当当前行大于值且上一行也大时　
        while(matrix[lastIndex][n-1] > target
                && lastIndex != 0 && matrix[lastIndex-1][n-1] >= target){
            lastIndex--;
        }

        if(matrix[lastIndex][0] > target){
            return false;
        }

        for(int i = 1; i<n; i++){
            if(matrix[lastIndex][i] > target){
                return false;
            }else if(matrix[lastIndex][i] == target){
                return true;
            }
        }
        return false;
    }
}
