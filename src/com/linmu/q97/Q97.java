package com.linmu.q97;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/17 3:46 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q97 {
    public static void main(String[] args) {
        System.out.println(new Solution().isInterleave("aabcc",
                "dbbca",
                "aadbbcbcac"));;
    }
}

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for(int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for(int i = 1; i <= s2.length(); i++) {
            dp[0][i] = dp[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        }
        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                dp[i][j] = (dp[i-1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j-1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
