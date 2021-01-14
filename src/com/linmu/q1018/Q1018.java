package com.linmu.q1018;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/14 8:32 上午
 * @description：leetcode q1018
 * @modified By：
 * @version: 1.0
 */
public class Q1018 {
    public static void main(String[] args) {

    }
}


class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>(A.length);
        int baseNum = 0;

        for(int num : A){
            baseNum *= 2;
            baseNum += num;
            baseNum %= 10;

            list.add(baseNum % 5 == 0);
        }

        return list;
    }
}