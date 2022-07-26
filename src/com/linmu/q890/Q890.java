package com.linmu.q890;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author ：xxx_
 * @date ：Created in 2022/6/13 16:28
 * @description：
 * @modified By：
 * @version:
 */
public class Q890 {
    public static void main(String[] args) {
        System.out.printf("", new Solution().findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abbc"));
    }
}


//arr = [1, 2, 2]


class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();

        int length = pattern.length();


        int[] match = new int[length];
        int[] position = new int[26];
        for (int i = 0; i < length; i++) {
            int value = pattern.charAt(i) - 'a';
            if(position[value] == 0) {
                position[value] = i + 1;
            }
            match[i] = position[value];
        }

        continuePoint: for (String word : words) {
            // 匹配校验
            int[] newMatch = new int[length];
            position = new int[26];
            for (int i = 0; i < length; i++) {
                int value = word.charAt(i) - 'a';
                if(position[value] == 0) {
                    position[value] = i + 1;
                }
                newMatch[i] = position[value];
            }
            for (int i = 0; i < length; i++) {
                if(newMatch[i] != match[i]) {
                    continue continuePoint;
                }
            }
            ans.add(word);
        }
        return ans;
    }
}
