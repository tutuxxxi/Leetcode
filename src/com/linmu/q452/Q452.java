package com.linmu.q452;

import java.util.Arrays;
import java.util.Comparator;

public class Q452 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}
        };

        System.out.println(new Solution().findMinArrowShots(arr));
    }
}

class Solution {
    public int findMinArrowShots(int[][] points) {

        if(points == null || points.length == 0)
            return 0;
        if(points.length == 1)
            return 1;

        Arrays.sort(points, (o1, o2) -> {
            if(o1[0] == o2[0])
                return Integer.compare(o1[1], o2[1]);
            else
                return Integer.compare(o1[0], o2[0]);
        });

        //存储箭的数量
        int count = 1;

        //如果在区域中，则存储该区域的最大值
        int endNum = points[0][1];

        for(int i = 1; i < points.length; i++){

            //超过了限定区域
            //新发射一支箭 并记录最后值
            if(points[i][0] > endNum){
                count++;
                endNum = points[i][1];
            }else{
                //如果新的区间的最高点比之前的最高点小
                //更新
                if(points[i][1] < endNum)
                    endNum = points[i][1];
            }
        }

        return count;
    }
}
