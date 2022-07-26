package com.linmu.q72;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/14 9:38 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q72 {
    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("sea", "ate"));
    }
}


class Solution {
    public int minDistance(String word1, String word2) {
        // dp[i][j]: 前i个转换为前j个需要的最少操作数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        // 初始化边界
        for(int i = 0; i <= chars1.length; i++) {
            dp[i][0] = i;
        }
        for(int j = 0; j <= chars2.length; j++) {
            dp[0][j] = j;
        }


        for(int i = 1; i <= chars2.length; i++) {
            for(int j = 1; j <= chars1.length; j++) {
                int res;

                if(chars1[j-1] == chars2[i-1]) {
                    // 使用当前字符
                    res = dp[j-1][i-1];
                }else{
                    // 替换/删除 当前字符
                    res = Math.min(dp[j-1][i], dp[j-1][i-1]) + 1;

                    // 插入字符
                    for(int k = i - 1; k > 0 && i - k < res; k--) {
                        res = Math.min(res, dp[j][k] + i - k);
                    }
                }

                dp[j][i] = res;
            }
        }

        return dp[chars1.length][chars2.length];
    }
}
