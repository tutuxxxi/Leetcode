package com.linmu.q1773;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by lijun
 * @since 2023/1/9 10:14
 */
public class Q1773 {
    public static void main(String[] args) {

    }
}

class Solution {

    private static final String TYPE = "type";

    private static final String COLOR = "color";

    private static final String NAME = "name";

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Map<String, Integer>> map = new HashMap<>(3);
        Map<String, Integer> typeMap = new HashMap<>(16);
        Map<String, Integer> colorMap = new HashMap<>(16);
        Map<String, Integer> nameMap = new HashMap<>(16);

        map.put(TYPE, typeMap);
        map.put(COLOR, colorMap);
        map.put(NAME, nameMap);
        for (List<String> item : items) {
            String type = item.get(0);
            String color = item.get(1);
            String name = item.get(2);
            typeMap.put(type, typeMap.getOrDefault(type, 0) + 1);
            typeMap.put(color, typeMap.getOrDefault(color, 0) + 1);
            typeMap.put(name, typeMap.getOrDefault(name, 0) + 1);
        }
        return map.get(ruleKey).get(ruleValue);
    }
}
