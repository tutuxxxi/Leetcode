package com.linmu.q1030;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Q1030 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().allCellsDistOrder(3,4,0,2)));
    }
}

class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R*C][2];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r0, c0});

        int index = 0;
        boolean[][] mark = new boolean[R][C];
        mark[r0][c0] = true;
        int[][] dir = new int[][]{
                {0, -1},
                {-1, 0},
                {0, 1},
                {1, 0}
        };

        while(!queue.isEmpty()){
            for(int i = 0 ; i<queue.size(); i++){
                int[] poll = queue.poll();

                res[index][0] = poll[0];
                res[index++][1] = poll[1];

                for(int j = 0; j < 4; j++){
                    int x = dir[j][0] + poll[0];
                    int y = dir[j][1] + poll[1];

                    if(x >= 0 && x < R && y >= 0 && y < C && mark[x][y] == false){
                        queue.offer(new int[]{ x, y});
                        mark[x][y] = true;
                    }
                }

            }
        }

        return res;
    }
}
