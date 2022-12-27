package com.linmu.q1513;

import java.util.*;

/**
 * @author by lijun
 * @since 2022/11/29 13:42
 */
public class Q1513 {
    public static void main(String[] args) {
        System.out.println(new Solution().numSub("11101010101001111010101111110010101111110101"));
    }
}

class Solution {

    private static final int mod = 1000000007;

    public int numSub(String s) {
        // 一次扫描记录连续的1的长度
        long ans = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                ans = (ans + val(count)) % mod;
                count = 0;
            } else {
                count++;
            }
        }
        return (int) (ans + val(count)) % mod;
    }

    private long val(long data) {
        return ((data * (data + 1)) / 2) % mod;
    }
}

//6 - 2
//4 - 1
//3 - 1
//1 - 10

// 6 - 2
// 5 - 4                        6
// 4 - 6 + 1                    13
// 3 - 8 + 2 + 1                24
// 2 - 10 + 3 + 2 + 1           40
// 1 - 12 + 4 + 3 + 10          69

// n -   1 + 2 + 3 + 4 + .... + n
// 6 * 7 / 2
