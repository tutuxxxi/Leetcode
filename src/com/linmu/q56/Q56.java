package com.linmu.q56;

import java.util.*;
import java.util.function.IntFunction;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/10 8:56 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q56 {
    public static void main(String[] args) {
        int[][] merge = new Solution().merge(new int[][]{
                {2, 3},
                {2, 2},
                {1, 2}
        });
        for(int[] arr : merge) {
            System.out.println(Arrays.toString(arr));
        }
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }else{
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        int preNum = intervals[0][0], nextNum = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > nextNum) {
                list.add(new int[]{preNum, nextNum});
                preNum = intervals[i][0];
            }
            nextNum = Math.max(nextNum, intervals[i][1]);
        }
        list.add(new int[]{preNum, nextNum});

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
