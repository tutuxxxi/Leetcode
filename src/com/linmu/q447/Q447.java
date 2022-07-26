package com.linmu.q447;

import java.io.UTFDataFormatException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/13 9:54 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q447 {
    public static void main(String[] args) {
        new Solution().numberOfBoomerangs(new int[][]{
                {1,1},
                {2,2},
                {3,3}
        });
    }
}


class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points.length < 3) {
            return 0;
        }
        int res = 0;

        /* 暴力1
        for(int i = 0; i < points.length; i++) {
            int[] point = points[i];
            Map<Integer, Integer> map = new HashMap<>();

            for(int j = 0; j < points.length; j++) {
                int x = Math.abs(point[0] - points[j][0]);
                int y = Math.abs(point[1] - points[j][1]);

                if(x != 0 || y != 0) {
                    int length = x * x + y * y;
                    map.put(length, map.getOrDefault(length, 0) + 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int num = entry.getValue();
                if(num >= 2) {
                    res += num * (num - 1);
                }
            }
        }
         */


        /* 暴力2
        int[][] map = new int[points.length][];
        for(int i = 0; i < points.length; i++) {
            Map<Integer, Integer> valueMap = new HashMap<>();
            map[i] = new int[points.length];
            int[] point = points[i];

            for (int j = 0; j < points.length; j++) {
                if (map[j] != null) {
                    map[i][j] = map[j][i];
                } else {
                    int x = Math.abs(point[0] - points[j][0]);
                    int y = Math.abs(point[1] - points[j][1]);

                    if (x != 0 || y != 0) {
                        int length = x * x + y * y;
                        map[i][j] = length;
                    }
                }
                valueMap.put(map[i][j], valueMap.getOrDefault(map[i][j], 0) + 1);
            }

            for (Integer value : valueMap.values()) {
                if (value >= 2) {
                    res += value * (value - 1);
                }
            }
        }
         */



        return res;
    }
}
