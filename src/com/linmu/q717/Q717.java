package com.linmu.q717;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/1 9:44 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q717 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        // dp[i]表示前i个是否构成比特字符串
        boolean[] dp = new boolean[bits.length];
        dp[0] = true;

        for(int i = 1; i<bits.length; i++){
            if(bits[i-1] == 0){
                dp[i] = dp[i] || dp[i-1];
                if(i > 1 && bits[i-2] == 1){
                    dp[i] = dp[i] || dp[i-2];
                }
            }else{
                if(i > 1 && bits[i-2] == 1){
                    dp[i] = dp[i] || dp[i-2];
                }
            }
        }

        return dp[bits.length-1];
    }
}
