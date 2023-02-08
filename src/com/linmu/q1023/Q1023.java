package com.linmu.q1023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author by lijun
 * @since 2023/1/9 13:34
 */
public class Q1023 {
    public static void main(String[] args) {
        new Solution().camelMatch(new String[]{"qweFooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FB");
    }
}

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int length = queries.length;
        List<Boolean> ans = new ArrayList<>(length);
        Arrays.stream(queries).forEach(str -> ans.add(match(str, pattern)));
        return ans;
    }

    private boolean match(String str, String pattern) {
        int strLength = str.length();
        int patternLength = pattern.length();
        if(strLength < patternLength) {
            return false;
        }

        int strIndex = 0;
        int patternIndex = 0;
        while(strIndex != strLength) {
            char c = str.charAt(strIndex);
            // 如果有则直接消费
            if(patternIndex < patternLength && c == pattern.charAt(patternIndex)) {
                patternIndex++;
            }else if(c >= 'A' && c <= 'Z') {
                return false;
            }
            strIndex++;
        }
        return strIndex == strLength && patternIndex == patternLength;
    }
}
