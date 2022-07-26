package com.linmu.q38;

/**
 * @author ：xxx_
 * @date ：Created in 2021/10/15 1:22 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q38 {
    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(30));
    }
}

class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String str = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();

        for (int j = 0; j < str.length(); j++) {
            int count = 1;
            while (j + 1 < str.length() && str.charAt(j + 1) == str.charAt(j)) {
                count++;
                j++;
            }
            res.append(count).append(str.charAt(j));
        }

        return res.toString();
    }
}
