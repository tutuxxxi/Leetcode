package com.linmu.q264;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/11 1:29 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q264 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index, index1, index2, index3;
        index = index1 = index2 = index3 = 0;

        while(index != n-1){
            int res1 = dp[index1] * 2;
            int res2 = dp[index2] * 3;
            int res3 = dp[index3] * 5;
            int res = Math.min(res1, Math.min(res2, res3));

            if(res != dp[index]){
                dp[++index] = res;
            }

            //将res答案的指针移动
            if(res == res1){
                index1++;
            }
            if(res == res2){
                index2++;
            }
            if(res == res3){
                index3++;
            }
        }
        return dp[n-1];
    }
}
