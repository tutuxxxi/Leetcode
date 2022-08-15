package com.linmu.o32;

import java.util.Arrays;

/**
 * @author by lijun
 * @date 2022/8/12 19:29
 */
public class O32 {
    public static void main(String[] args) {
        new Solution().isAnagram(
                "anagram",
                "nagaram");
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        int length = 0;
        if((length = s.length()) != t.length() || s.equals(t)) {
            return false;
        }

        int[] count = new int[26];
        for (int index = 0; index < length; index++) {
            count[s.charAt(index) - 'a']++;
            count[t.charAt(index) - 'a']--;
        }
        return Arrays.stream(count).allMatch(num -> num == 0);
    }
}
