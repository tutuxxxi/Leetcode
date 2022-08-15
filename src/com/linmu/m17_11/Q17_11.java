package com.linmu.m17_11;

import java.util.*;

/**
 * @author by lijun
 * @date 2022/8/12 18:21
 */
public class Q17_11 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        List<Integer> fromIndex = new ArrayList<>();
        List<Integer> toIndex = new ArrayList<>();
        for (int index = 0; index < words.length; index++) {
            if(word1.equals(words[index])) {
                fromIndex.add(index);
            }else if(word2.equals(words[index])) {
                toIndex.add(index);
            }
        }

        // m * n
        int closest = Integer.MAX_VALUE;
        for (Integer index1 : fromIndex) {
            for (Integer index2 : toIndex) {
                closest = Math.min(closest, Math.abs(index1 - index2));
            }
        }
        return closest;
    }
}
