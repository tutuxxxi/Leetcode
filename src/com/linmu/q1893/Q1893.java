package com.linmu.q1893;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/23 8:40 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1893 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (o1, o2) -> o2[0] - o1[0]);

        //区间合并
        int[] temp = new int[2];

        return false;
    }
}
