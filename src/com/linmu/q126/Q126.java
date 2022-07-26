package com.linmu.q126;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/28 10:47 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q126 {
    public static void main(String[] args) {
        List<List<String>> ladders = new Solution().findLadders("qa", "sq", Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"));
        System.out.println(ladders.size());
    }
}

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 返回结果
        List<List<String>> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);

        if(set.contains(endWord)) {
            // 检索标识
            boolean[] mark = new boolean[wordList.size()];

            // map存储含义： word -> 能够到达word的路径集合
            Map<String, List<List<String>>> map = new HashMap<>();
            map.put(beginWord, Arrays.asList(Arrays.asList(beginWord)));

            // 当没有结果并且没有枚举完word的时候 继续枚举word
            while(res.isEmpty() && !map.isEmpty()) {
                // 当前层能够枚举的word
                Set<String> keys = map.keySet();

                // 临时map， 用于存储过程中产生的下一层枚举内容 (直接修改map会触发 fastFail)
                Map<String, List<List<String>>> tempMap = new HashMap<>();
                // 临时mark， 由于每个结点可能有多条路径到达，因此直接修改mark会导致答案缺失， 需要将mark修改延迟到枚举结束
                boolean[] tempMark = Arrays.copyOf(mark, mark.length);


                for (String key : keys) {
                    for (int i = 0; i < wordList.size(); i++) {
                        String word = wordList.get(i);
                        if(mark[i] == false && canParse(key, word)) {
                            // 生成路径
                            List<List<String>> tempList = new ArrayList<>();
                            List<List<String>> lists = map.get(key);
                            for (List<String> strings : lists) {
                                ArrayList<String> temp = new ArrayList<>(strings);
                                temp.add(word);
                                tempList.add(temp);
                            }

                            if(word.equals(endWord)) {
                                // 匹配结束
                                res.addAll(tempList);
                            }else{
                                // 结果累加
                                tempMark[i] = true;
                                List<List<String>> orDefault = tempMap.getOrDefault(word, new ArrayList<>());
                                orDefault.addAll(tempList);
                                tempMap.put(word, orDefault);
                            }
                        }
                    }
                }
                map = tempMap;
                mark = tempMark;
            }
        }
        return res;
    }



    private boolean canParse(String s1, String s2) {
        if(s1.length() == s2.length()) {
            boolean mark = false;
            for (int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)) {
                    if(mark) {
                        return false;
                    }
                    mark = true;
                }
            }
            return true;
        }
        return false;
    }
}
