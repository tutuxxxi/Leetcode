package com.linmu.q76;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/15 10:32 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q76 {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("bacb", "bab"));
    }
}


class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> match = new HashMap<>();
        HashMap<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        }

        String res = "";
        int len = 0x3f3f3f3f, matchNum = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char scan = s.charAt(i);

            // 扩展右指针并将扫描到字符记录在match中
            match.put(scan, match.getOrDefault(scan, 0) + 1);

            // 如果字符匹配且未超过需要匹配的target量，则记录匹配数
            if (target.containsKey(scan) && match.get(scan) <= target.get(scan)) {
                matchNum++;
            }

            // 如果存在多余的字符 则将其移出
            while (j < i && (!target.containsKey(s.charAt(j)) || match.get(s.charAt(j)) > target.get(s.charAt(j)))) {
                int count = match.get(s.charAt(j)) - 1;
                match.put(s.charAt(j), count);
                j++;
            }

            // 判断是否为更优匹配解
            if (matchNum == t.length() && i - j + 1 < len) {
                len = i - j + 1;
                res = s.substring(j, i + 1);
            }
        }
        return res;
    }
}
