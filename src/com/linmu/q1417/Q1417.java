package com.linmu.q1417;

import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author by lijun
 * @date 2022/8/11 8:31
 */
public class Q1417 {
    public static void main(String[] args) {
        new Solution().reformat("a0b1c2");
    }
}

class Solution {

    public String reformat(String s) {
        Map<Boolean, List<Character>> collect = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Character::isLetter));
        Queue<Character> letterList = new LinkedList<>(collect.getOrDefault(true, new ArrayList<>()));
        Queue<Character> numList = new LinkedList<>(collect.getOrDefault(false, new ArrayList<>()));

        if(Math.abs(letterList.size() - numList.size()) <= 1) {
            StringBuilder str = new StringBuilder();
            Queue<Character> firstList, secondList;

            if(letterList.size() > numList.size()) {
                str.append(letterList.remove());
                firstList = numList;
                secondList = letterList;
            }else if(letterList.size() < numList.size()){
                str.append(numList.remove());
                firstList = letterList;
                secondList = numList;
            }else {
                firstList = letterList;
                secondList = numList;
            }

            int listSize = firstList.size();
            for (int index = 0; index < listSize; index++) {
                str.append(firstList.remove());
                str.append(secondList.remove());
            }
            return str.toString();
        }
        return "";
    }
}
