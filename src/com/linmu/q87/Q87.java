package com.linmu.q87;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/16 6:36 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q87 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;



        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int n = s1.length();

        // dp[i][j][k]代表 s1第i位后的k个字符串是否与s2第j位后的k个字符串相互为扰乱字符串
        // 很明显的，对于任意dp[i][j][1] = cs1[i] == cs2[j]
        // 当k值大于1之后，需要进行条件判断：
        //    dp[i][j][k] = 对字符串k的任意位置进行分割，如果分割得到的两个子串都逆转，则原串逆转
        boolean[][][] dp = new boolean[n][n][n + 1];

        // 将长度为1的起始条件设置好
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = cs1[i] == cs2[j];
            }
        }

        // 对于其他长度而言，需要进行寻找拆分位置
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {

                    //已知此时长度为len， 尝试找一个len的分割位置，使得分割的两个串长度逆转
                    for (int k = 1; k < len; k++) {
                        // 在第k位置分割，如果两个串不反转，则匹配规则为 dp[i][j][k] && dp[i + k][j + k][len - k]
                        boolean a = dp[i][j][k] && dp[i + k][j + k][len - k];
                        // 如果反转， 则匹配规则为 dp[i][j + len - k][k] && dp[i + k][j][len - k];
                        boolean b = dp[i][j + len - k][k] && dp[i + k][j][len - k];
                        if (a || b) {
                            dp[i][j][len] = true;
                            // 剪枝
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}
