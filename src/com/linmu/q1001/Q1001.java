package com.linmu.q1001;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/8 4:42 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1001 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().gridIllumination(6, new int[][]{
                {2,5},{4,2},{0,3},{0,5},{1,4},{4,2},{3,3},{1,0}
        }, new int[][]{
                {4,3},{3,1},{5,3},{0,5},{4,4},{3,3}
        })));
    }
}

class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Set<String> set = new HashSet<>();
        int[] res = new int[queries.length];

        for(int[] lamp : lamps){
            set.add(lamp[0] + "-" + lamp[1]);
        }

        for(int i = 0; i<queries.length; i++){
            int[] query = queries[i];

            for(String s : set){
                String[] split = s.split("-");
                int x = Integer.valueOf(split[0]);
                int y = Integer.valueOf(split[1]);

                long absX = Math.abs(x-query[0]);
                long absY = Math.abs(y-query[1]);

                if(absX == 0 || absY == 0 || absY == absX){
                    res[i] = 1;
                    break;
                }
            }

            set.remove(query[0] + "-" + query[1]);
            set.remove((query[0]-1) + "-" + (query[1]-1));
            set.remove((query[0]-1) + "-" + query[1]);
            set.remove((query[0]-1) + "-" + (query[1]+1));
            set.remove(query[0] + "-" + (query[1]-1));
            set.remove(query[0] + "-" + (query[1]+1));
            set.remove((query[0]+1) + "-" + (query[1]+1));
            set.remove((query[0]+1) + "-" + query[1]);
            set.remove((query[0]+1) + "-" + (query[1]-1));
        }

        return res;
    }
}
