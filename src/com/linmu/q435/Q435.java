package com.linmu.q435;

import java.util.Arrays;
import java.util.Comparator;

public class Q435 {
    public static void main(String[] args) {
        new Solution().eraseOverlapIntervals(new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        });
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }else{
                return o1[0] - o2[0];
            }
        });

        //从前往后遍历，将覆盖区域大的尽量去除
        int[] temp = intervals[0];
        int count = 0;
        for(int i = 1; i < intervals.length; i++){
            //区间是经过排序的，因此一定有 temp[0] <= intervals[i][0]
            if(temp[1] > intervals[i][0]){
                //两个区间重合
                if(temp[1] >= intervals[i][1]){
                    //区间2被区间1包含，则无条件去除区间1：
                    //      因为区间2能覆盖的面积更小，发生重合的概率更小，并且区间2重合的情况下区间1一定重合，反之却不一定
                    //增加去除数
                    count++;
                    //标记区间改为当前区间（去除前一区间）
                    temp = intervals[i];
                }else{
                    //区间2与区间1相交，则去除区间2：
                    //      因为当我们走到这一步时，区间1与前方不会发生重合，并且区间1较小，应该保留区间1
                    count++;
                }
            }else{
                //两个区间没有重合
                temp = intervals[i];
            }
        }

        return count;
    }
}
