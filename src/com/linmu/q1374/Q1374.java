package com.linmu.q1374;

/**
 * @author by lijun
 * @date 2022/8/1 8:37
 */
public class Q1374 {
    public static void main(String[] args) {

    }
}

class Solution {
    public String generateTheString(int n) {
        if(n % 2 == 0) {
            return generateTheString(n - 1) + "b";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append("a");
        }
        return stringBuilder.toString();
    }
}
