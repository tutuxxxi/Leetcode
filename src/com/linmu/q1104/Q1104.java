package com.linmu.q1104;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/29 1:39 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1104 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString((-(~6)) ^ Integer.MIN_VALUE));
//        System.out.println(new Solution().pathInZigZagTree(14));
    }
}

class Solution {
//    public List<Integer> pathInZigZagTree(int label) {
//        String s = Integer.toBinaryString(label);
//        List<Integer> res = new ArrayList<>();
//        res.add(label);
//
//        while(s.length() != 1){
//            char[] chars = s.toCharArray();
//
//            for(int i = 1; i<chars.length-1; i++){
//                chars[i] = chars[i] == '0' ? '1' : '0';
//            }
//
//            s = new String(chars).substring(0, chars.length-1);
//
//            res.add(Integer.valueOf(s, 2));
//        }
//
//        Collections.reverse(res);
//        return res;
//    }

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();

        while(label != 1){
            res.add(label);
            label >>= 1;
            label = label ^(1 << (Integer.bitCount(label) - 1)) - 1;
        }

        Collections.reverse(res);
        return res;
    }
}
