package com.linmu.q1408;

import java.util.*;

/**
 * @author by lijun
 * @date 2022/8/9 8:44
 */
public class Q1408 {
    public static void main(String[] args) {
    }
}

class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
        List<String> ans = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(words).forEach(str -> {

            stringBuilder.append(str);
        });

        return ans;
    }
}
