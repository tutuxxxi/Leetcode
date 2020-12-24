package com.linmu.q767;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Q767 {
    public static void main(String[] args) {
        System.out.println(new Solution().reorganizeString("vvvlo"));

    }
}


class Solution {
//    public String reorganizeString(String S) {
//
//
//        char[] chars = S.toCharArray();
//
//        int[][] count = new int[26][2];
//
//        for(char c : chars){
//            int index = c - 'a';
//            count[index][0] = c;
//            count[index][1]++;
//        }
////
////        Arrays.sort(count, (o1, o2) -> o2[1] - o1[1]);
////
////        if(count[0][1] > (chars.length + 1) / 2)
////            return "";
//
//        //chars的index
//        int chIndex = 0;
//        //count的index
//        int coIndex = 0;
//
//        while(coIndex < 26){
//
//            //如果count位置的字符还存在，就将其放入间隔位中
//            while(count[coIndex][1] > 0){
//
//                //存入字符
//                chars[chIndex] = (char)count[coIndex][0];
//
//                //chars指针移动
//                chIndex += 2;
//                if(chIndex >= chars.length)
//                    chIndex = 1;
//
//                //数量减少
//                count[coIndex][1]--;
//            }
//
//            coIndex++;
//        }
//
//        return new String(chars);
//    }

    public String reorganizeString(String S) {

        char[] chars = S.toCharArray();

        int[] count = new int[26];

        for(char c : chars){
            count[c - 'a']++;
        }

        int maxIndex = 0;
        for(int i = 1; i< 26; i++){
            if(count[i] > count[maxIndex])
                maxIndex = i;
        }

        if(count[maxIndex] > ((chars.length + 1) / 2))
            return "";

        int chIndex = 0;

        while(count[maxIndex]-- > 0){
            chars[chIndex] = (char)('a' + maxIndex);
            chIndex += 2;

            //上面已经设置了，则本次循环chIndex不可能超标
        }

        maxIndex = 0;

        while(maxIndex < 26){

            while(count[maxIndex]-- > 0){

                if(chIndex >= chars.length)
                    chIndex = 1;

                chars[chIndex] = (char)('a' + maxIndex);
                chIndex += 2;
            }
            maxIndex++;
        }

        return new String(chars);
    }
}