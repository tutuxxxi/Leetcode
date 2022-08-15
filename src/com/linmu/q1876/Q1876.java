package com.linmu.q1876;

/**
 * @author by lijun
 * @date 2022/8/12 19:37
 */
public class Q1876 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int countGoodSubstrings(String s) {
        int ans = 0;
        int length = s.length();
        if(length >= 3) {
            int index = 0;
            char c1, c2 = s.charAt(index++), c3 = s.charAt(index++);
            while(index != length) {
                c1 = c2;
                c2 = c3;
                c3 = s.charAt(index++);

                if(c1 != c2 && c1 != c3 && c2 != c3) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
