package com.linmu.q389;

import java.util.ArrayList;
import java.util.Arrays;

public class Q389 {
    public static void main(String[] args) {

    }
}

class Solution {
//    public char findTheDifference(String s, String t) {
//        char[] chars = s.toCharArray();
//        char[] chart = t.toCharArray();
//
//        Arrays.sort(chars);
//        Arrays.sort(chart);
//
//        for(int i = 0; i<chars.length; i++){
//            if(chars[i] !=  chart[i]){
//                return chart[i];
//            }
//        }
//
//        return chart[chars.length];
//    }
    public char findTheDifference(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        int count = 0;

        for(char c : chars){
            count ^= c;
        }
        for(char c : chart){
            count ^= c;
        }

        return (char) count;
    }

}
