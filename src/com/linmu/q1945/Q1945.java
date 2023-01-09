package com.linmu.q1945;

/**
 * @author by lijun
 * @since 2022/12/27 15:45
 */
public class Q1945 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int getLucky(String s, int k) {
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            str.append(c - 'a' + 1);
        }
        String numStr = str.toString();
        for (int i = 1; i < k; i++) {
            numStr = String.valueOf(getVal(numStr));
        }
        return getVal(numStr);
    }

    private int getVal(String num) {
        int ans = 0;
        for (char c : num.toCharArray()) {
            ans += c - '0';
        }
        return ans;
    }
}
