package com.linmu.q3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("awgawserfasdfazwesf"));
    }
}


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null)
            return 0;

        int length = s.length();
        if(length == 1 || length == 0)
            return length;

        /*
        Map<Character, Integer> map = new HashMap<>();

        char c;
        int max = 0;
        int count = 0;
        int i = 0;
        while(i<length){
            c = s.charAt(i);


            if(map.get(c) == null){
                count++;
                map.put(c, 1);
                i++;
            }else{
                max = Math.max(max, count);

                i = i - count + s.substring(i - count, i).indexOf(c) + 1;

                map.clear();
                count = 1;
                map.put(s.charAt(i++), 1);
            }
        }
        max = Math.max(max, count);

        return max;
         */

        Set<Character> set = new HashSet<>();
        int max = 0;   //记录最大子串
        int start = 0;  //记录起始位置
        int end = 0;    //记录结束位置
        int error = 0;   //记录出现重复位置index
        char c;             //临时存储字符

        while(end < length){
            c = s.charAt(end);

            if(set.contains(c)){

                //记录当前子串长度
                max = Math.max(max, end-start);

                //eroor标识起始位置，通过函数获取当前查询字串中c的位置，加上start位置变成error位置
                error = s.substring(start, end).indexOf(c) + start;

                //将起点到出现错误中间的字符都删除 error位置的字符不用删，因为end位置和error位置的字符相同（待会儿又得加回去）
                for(int i = start; i < error; i++){
                    set.remove(s.charAt(i));
                }


                //重新规划起点
                start = error + 1;

            }else{
                set.add(c);
            }

            end++;
        }

        return max;
    }
}