package com.linmu.q973;

import java.util.Arrays;
import java.util.Comparator;

public class Q973 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if(K == points.length)
            return points;

        /*
        简化过程一： 实现接口

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] * o1[0] + o1[1] * o1[1]) - (o2[0] * o2[0] + o2[1] * o2[1]);
            }
        });
         */

        /*
        简化过程二： 转化为lambda表达式

        Arrays.sort(points, (o1, o2) -> {
            return (o1[0] * o1[0] + o1[1] * o1[1]) - (o2[0] * o2[0] + o2[1] * o2[1]);
        });

         */



        /*
        简化过程三： 通过Comparator.comparingInt函数自动构造Comparator对象
         */
        Arrays.sort(points, Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));

        return Arrays.copyOf(points, K);
    }
}