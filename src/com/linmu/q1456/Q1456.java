package com.linmu.q1456;

import java.util.Map;

/**
 * @author by lijun
 * @since 2022/12/2 9:45
 */
public class Q1456 {
    public static void main(String[] args) {
        System.out.println((int) '0');
        System.out.println((int) '1');
        System.out.println((int) '9');
    }
}


class Solution {
    public int maxVowels(String s, int k) {
        // 滑动窗口
        int maxSize = 0;
        for (int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i))) {
                maxSize++;
            }
        }

        int length = s.length() - k;
        int size = maxSize;
        for (int i = 1; i <= length; i++) {
            if(isVowel(s.charAt(i - 1))) {
                size--;
            }
            if(isVowel(s.charAt(i + k - 1))) {
                size++;
            }
            maxSize = Math.max(maxSize, size);
        }
        return maxSize;
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
