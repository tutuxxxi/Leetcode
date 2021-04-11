package com.linmu.q1143;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/3 9:26 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1143 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonSubsequence("ihefilushawgiuawbfgiuahwigua", "woehfaiuwehb"));
    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2){
        int length1 = text1.length(), length2 = text2.length();

        //dp[i][j]: text1前i个和text2前j个构成的公共子序列长度
        int[][] dp = new int[length1+1][length2+1];
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        for(int i = 1 ; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                //对text1前i个，text2前j个，他们的最大匹配数
                //应该等于第j在text中的位置的前一个位置的最大子序列数+1
                int max = 0;

                //对text1遍历
                for(int k = 1; k <= i; k++){
                    if(chars1[k-1] == chars2[j-1]){
                        //代表当前位置能够匹配
                        max = Math.max(max, dp[k-1][j-1]+1);
                    }
                }

                dp[i][j] = Math.max(max, dp[i][j-1]);
            }
        }

        return dp[length1][length2];
    }
}
