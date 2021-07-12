package com.linmu.q986;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/6/9 9:22 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q986 {
    public static void main(String[] args) {
        int[][] ints = new Solution().intervalIntersection(new int[][]{{1, 3}, {5, 9}}, new int[0][0]);
        System.out.println("nice");
    }
}

/*
[[3,5],[9,20]]
[[4,5],[7,10],[11,12],[14,15],[16,20]]
 */


class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList();
        int firstIndex = 0, secondIndex = 0;

        while (firstIndex < firstList.length && secondIndex < secondList.length) {
            int first = Math.max(firstList[firstIndex][0], secondList[secondIndex][0]);
            int second = Math.min(firstList[firstIndex][1], secondList[secondIndex][1]);

            // 证明有相交
            if (first <= second){
                ans.add(new int[]{first, second});
            }

            // 将后位较小的后移
            if (firstList[firstIndex][1] < secondList[secondIndex][1]){
                firstIndex++;
            }else {
                secondIndex++;
            }
        }

        return ans.toArray(new int[0][0]);
    }
}