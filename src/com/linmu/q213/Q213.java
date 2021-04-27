package com.linmu.q213;

import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/15 1:26 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q213 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int rob(int[] nums) {
        //第一位表示前n个数字， 第二位表示是否取了第一位， 第三位表示是否取了当前位
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }
        int[][] dp = new int[length][2];
        int[] preMax = new int[2];


        dp[0][1] = nums[0];



        for(int i = 1; i < length - 1; i++){
            int[] nowMax = new int[]{
                    Math.max(preMax[1], preMax[0]),
                    preMax[0] + nums[i]
            };
            preMax = nowMax;
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        //到最后一位时，需要特殊判断
        return Math.max(preMax[0] + nums[length-1], Math.max(preMax[1], Math.max(dp[length-2][0], dp[length-2][1])));
    }
}
