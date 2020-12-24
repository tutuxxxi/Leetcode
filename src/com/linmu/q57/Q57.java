package com.linmu.q57;

import java.util.Arrays;

public class Q57 {
    public static void main(String[] args) {
        int[][] a = new int[4][2];
        a[0][0] = 1;
        a[0][1] = 3;
        a[1][0] = 6;
        a[1][1] = 9;
        a[2][0] = 12;
        a[2][1] = 15;
        a[3][0] = 17;
        a[3][1] = 100;
        //a[4][0] = 12;
        //a[4][1] = 16;

        int[] b = new int[2];
        b[0] = 1;
        b[1] = 100;

        System.out.println(Arrays.toString(new Solution().insert(a,b)));
    }
}


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //不用添加区间
        if(newInterval.length == 0)
            return intervals;

        int length = intervals.length;
        //最多会有length+1个区间输出
        int[][] res = new int[length + 1][2];

        //原本没有区间
        if(length == 0){
            res[0] = newInterval;
            return res;
        }

        int index = 0;
        //检索拼接区间信号
        boolean signal = false;
        boolean deal = false;

        for(int i = 0; i < length; i++){

            //与区间没有交叉
            if(intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1]){

                //没有交叉不代表当前不是填入此项
                if(!deal && intervals[i][0] > newInterval[1]){
                    res[index][0] = newInterval[0];
                    res[index++][1] = newInterval[1];
                    deal = true;
                }

                if(signal){
                    signal = false;
                    index++;
                }

                res[index][0] = intervals[i][0];
                res[index++][1] = intervals[i][1];
            }else{
                //与区间有交叉

                //并且当前为首次遇到新添加区间
                if(!signal){
                    //设置区间左值
                    res[index][0] = Math.min(intervals[i][0], newInterval[0]);
                    signal = true;
                    deal = true;
                }

                //设置区间右值
                res[index][1] = Math.max(intervals[i][1], newInterval[1]);

            }

        }

        if(signal){
            signal = false;
            index++;
        }

        if(!deal){
            res[index][0] = newInterval[0];
            res[index++][1] = newInterval[1];
        }

        return Arrays.copyOf(res, index);
    }
}
