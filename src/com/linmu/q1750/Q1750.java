package com.linmu.q1750;

/**
 * @author by lijun
 * @since 2022/12/28 8:39
 */
public class Q1750 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minimumLength(String s) {
        int ans = s.length();
        int preIndex = 0;
        int lastIndex = ans - 1;
        char c;

        while(preIndex < lastIndex && (c = s.charAt(preIndex)) == s.charAt(lastIndex)) {
            while(preIndex <= lastIndex && c == s.charAt(preIndex)) {
                ans--;
                preIndex++;
            }
            while(lastIndex >= preIndex && c == s.charAt(lastIndex)) {
                ans--;
                lastIndex--;
            }
        }
        return ans;
    }
}
