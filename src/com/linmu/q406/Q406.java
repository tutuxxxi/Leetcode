package com.linmu.q406;

import java.util.Arrays;
import java.util.Comparator;

public class Q406 {
    public static void main(String[] args) {
        //[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
        int[][] people = new int[][]{
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };

        new Solution().reconstructQueue(people);
    }
}

class Solution {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (o1, o2) -> {
            if(o1[0] == o2[0])
                return o2[1] - o1[1];
            else
                return o1[0] - o2[0];
        });

        int[][] res = new int[people.length][2];
        int[] mark = new int[people.length];

        for(int[] i : people){
            int index = -1;

            //找到插入的位置
            for(int j = 0; j < people.length; j++){
                if(mark[j] == 0){
                    if(++index == i[1]){
                        index = j;
                        break;
                    }
                }
            }

            res[index] = i;
            mark[index] = 1;
        }

        return res;

    }
}
