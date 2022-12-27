package com.linmu.q1759;

/**
 * @author by lijun
 * @since 2022/12/26 11:05
 */
public class Q1759 {
    public static void main(String[] args) {
        System.out.println(new Solution().countHomogenous("aabbbc"));
    }
}

class Solution {
    private static final int MOD = 1000000007;

    public int countHomogenous(String s) {
        // 双指针找连续串
        // 计算数量

        int ans = 0;
        int length = s.length();

        char preC = s.charAt(0);
        int commonLength = 1;

        for (int i = 1; i < length; i++) {
            char currentC = s.charAt(i);
            if(currentC != preC) {
                ans = (ans + getNum(commonLength)) % MOD;
                commonLength = 0;
                preC = currentC;
            }
            commonLength++;
        }
        return (ans + getNum(commonLength)) % MOD;
    }

    private static int getNum(int length) {
        return (int) (length * ((double) length + 1) / 2 % MOD);
    }
}
