package com.linmu.q187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：xxx_
 * @date ：Created in 2021/10/8 9:38 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q187 {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for(int i = 0; i + 9 < s.length(); i++) {
            String substring = s.substring(i, i + 10);
            map.put(substring, map.getOrDefault(substring, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}
