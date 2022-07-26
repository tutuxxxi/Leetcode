package com.linmu.q140;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/30 3:04 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q140 {
    public static void main(String[] args) {
        System.out.println("a".substring(0, 1));
    }
}

class Solution {
    StringBuilder stringBuilder = new StringBuilder();
    List<String> res = new ArrayList<>();
    Set<String> wordDict;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = new HashSet<>(wordDict);
        wordBreak(s);
        return res;
    }

    public void wordBreak(String s) {
        if(s == null || s.equals("") || s.length() == 0) {
            res.add(stringBuilder.toString());
        }else{

            for(int i = 1; i<=s.length(); i++) {
                String substring = s.substring(0, i);
                if(wordDict.contains(substring)) {
                    int index = 0;
                    if((index = stringBuilder.length()) != 0) {
                        substring = " " + substring;
                    }
                    stringBuilder.append(substring);
                    wordBreak(s.substring(i));
                    stringBuilder.delete(index, stringBuilder.length());
                }
            }
        }
    }
}
