package com.linmu.q566;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/17 14:21
 * @description：leetcode q566
 * @modified By：
 * @version: 1.0
 */
public class Q566 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length * nums[0].length != r * c){
            return nums;
        }else{

            int[][] res = new int[r][c];
            int width = nums[0].length;

            for(int i = 0; i < r * c; i++){
                res[i/c][i%c] = nums[i/width][i%width];
            }
            return res;
        }
    }
}
