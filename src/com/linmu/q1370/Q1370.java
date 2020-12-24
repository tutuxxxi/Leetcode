package com.linmu.q1370;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q1370 {
    public static void main(String[] args) {
        System.out.println(new Solution().sortString("spo"));
    }
}

class Solution {
    public String sortString(String s) {
        int[] mark = new int[26];

        //记录各个字符个数
        for(char c : s.toCharArray()){
            mark[c - 'a']++;
        }

        StringBuilder stringBuilder = new StringBuilder("");

        int index = -1;
        while(stringBuilder.length() < s.length()){
            if(index == -1){
                index = 0;

                while(index < 26){
                    if(mark[index] != 0){
                        mark[index]--;
                        stringBuilder.append((char)(index + 'a'));
                    }
                    index++;
                }

            }else {
                index = 25;

                while(index > -1){
                    if(mark[index] != 0){
                        mark[index]--;
                        stringBuilder.append((char)(index + 'a'));
                    }
                    index--;
                }
            }
        }

        return stringBuilder.toString();
    }
}
