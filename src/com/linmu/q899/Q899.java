package com.linmu.q899;

import java.util.Arrays;

/**
 * @author by lijun
 * @date 2022/8/3 8:32
 */
public class Q899 {
    public static void main(String[] args) {

    }
}

class Solution {
    public String orderlyQueue(String s, int k) {
        if(k == 1) {
            StringBuilder stringBuilder = new StringBuilder(s);
            String res = s;

            for (int i = 0; i < s.length(); i++) {
                stringBuilder = new StringBuilder(stringBuilder.substring(1)).append(stringBuilder.charAt(0));
                if(res.compareTo(stringBuilder.toString()) > 0) {
                    res = stringBuilder.toString();
                }
            }
            return res;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
