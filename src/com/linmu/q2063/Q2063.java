package com.linmu.q2063;

import java.util.Random;

/**
 * @author by lijun
 * @date 2022/8/24 11:12
 */
public class Q2063 {
    public static void main(String[] args) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append((char) ( random.nextInt(26) + 'a'));
        }
        System.out.println(stringBuilder.toString());
//        new Solution().countVowels("abcdef");
    }
}

class Solution {
    public long countVowels(String word) {
        int length = word.length();

        // dp1[n] : 前n个字符的子字符串中 元音的总数
        // dp2[n] : 前n个字符的以n字符结尾的子字符串中 元音的总数
        long[] dp1 = new long[length], dp2 = new long[length];
        dp1[0] = dp2[0] = isVowel(word.charAt(0)) ? 1 : 0;

        for (int index = 1; index < length; index++) {
            char c = word.charAt(index);
            if(isVowel(c)) {
                dp2[index] = dp2[index - 1] + index + 1;
                dp1[index] = dp1[index - 1] + dp2[index - 1] + index + 1;
            }else {
                dp2[index] = dp2[index - 1];
                dp1[index] = dp1[index - 1] + dp2[index - 1];
            }
        }
        return dp1[length - 1];
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
