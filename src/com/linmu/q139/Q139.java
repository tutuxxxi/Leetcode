package com.linmu.q139;

import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/30 2:39 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q139 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }
}
