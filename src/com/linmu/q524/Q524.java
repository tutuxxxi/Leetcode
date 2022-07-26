package com.linmu.q524;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/14 8:53 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q524 {
    public static void main(String[] args) {
        new Solution().findLongestWord("123", Arrays.asList("ale","apple","monkey","plea", "alc", "a", "b", "c"));
    }
}


class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, (o1, o2) -> {
            if(o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o2.length() - o1.length();
        });

        char[] chars = s.toCharArray();

        for (String s1 : dictionary) {
            char[] chars1 = s1.toCharArray();
            if(chars.length >= chars1.length && judge(chars, chars1)) {
                return s1;
            }
        }
        return "";
    }


    private boolean judge(char[] chars1, char[] chars2) {
        int index = 0;
        for(int i = 0; i < chars2.length; i++) {
            while(index < chars1.length && chars1[index] != chars2[i]) {
                index++;
            }

            if(index == chars1.length) {
                return false;
            }else {
                index++;
            }
        }
        return true;
    }
}
