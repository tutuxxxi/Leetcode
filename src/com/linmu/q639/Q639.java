package com.linmu.q639;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/27 8:39 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q639 {
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("*1*1*0"));
    }
}

class Solution {
    private final int MOD = 1000000007;

    public int numDecodings(String s) {
        int length = s.length();
        // dp[i] = 前i个字符编码方式
        int[] dp = new int[length + 1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : s.charAt(0) == '*' ? 9 : 1;
        for(int i = 1; i < length; i++) {
            char currentChar = s.charAt(i);
            char preChar = s.charAt(i-1);

            // 自己作为独立解析方式
            if(currentChar != '0') {
                dp[i+1] = (dp[i + 1] + dp[i] * (currentChar == '*' ? 9 : 1)) % MOD;
            }


            // 自己和前一字符共同组成解析
            if((preChar < '3' || preChar > '9') && preChar != '0') {
                if(preChar == '*') {
                    if(currentChar == '*') {
                        dp[i+1] = (dp[i + 1] + dp[i-1] * 15) % MOD;
                    }else if(currentChar >= '0' && currentChar <= '6'){
                        dp[i+1] = (dp[i + 1] + dp[i-1] * 2) % MOD;
                    }else{
                        dp[i+1] = (dp[i + 1] + dp[i-1]) % MOD;
                    }
                }else if(preChar == '1') {
                    if(currentChar == '*') {
                        dp[i+1] = (dp[i + 1] + dp[i-1] * 9) % MOD;
                    }else{
                        dp[i+1] = (dp[i + 1] + dp[i-1]) % MOD;
                    }
                }else if(preChar == '2'){
                    if(currentChar == '*') {
                        dp[i+1] = (dp[i + 1] + dp[i-1] * 6) % MOD;
                    }else if(currentChar >= '0' && currentChar <= '6') {
                        dp[i+1] = (dp[i + 1] + dp[i-1]) % MOD;
                    }
                }
            }
        }

        return dp[length];
    }
}
