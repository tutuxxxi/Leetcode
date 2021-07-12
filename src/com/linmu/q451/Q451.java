package com.linmu.q451;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/9 3:16 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q451 {
    public static void main(String[] args) {


    }
}

class Solution {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        Object[] objects = entries.stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).toArray();

        for(Object object : objects){
            Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) object;
            Character c = entry.getKey();
            for(int i = 0; i<entry.getValue(); i++){
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }
}
