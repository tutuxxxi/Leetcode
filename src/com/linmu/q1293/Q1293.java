package com.linmu.q1293;

import java.util.*;

/**
 * @author by lijun
 * @date 2022/8/19 9:54
 */
public class Q1293 {
    public static void main(String[] args) {
        new Solution().shortestPath(new int[][]{
                {0,0,0},
                {1,1,0},
                {0,0,0},
                {0,1,1},
                {0,0,0}
        }, 1);

    }
}

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int height = grid.length;
        int width = grid[0].length;

        // mark[x][y][n]: 从(x,y)出发，消除n个砖块到终点的最少步数
        Integer[][][] mark = new Integer[height][width][k];

        Deque<int[]> deque = new LinkedList<>();
        Set<String> set = new HashSet<>();
        List<int[]> wall = new ArrayList<>();

        int step = 0, wallNum = 0, queueSize;
        deque.offerLast(new int[]{height - 1, width - 1});
        while((queueSize = deque.size()) != 0) {
            for (int i = 0; i < queueSize; i++) {
                int[] dir = deque.pollFirst();
                if(grid[dir[0]][dir[1]] == wallNum) {
                    mark[dir[0]][dir[1]][wallNum] = step;
                    if(dir[0] != height - 1 && mark[dir[0] + 1][dir[1]][wallNum] == null) {
                        deque.offerLast(new int[]{dir[0] + 1, dir[1]});
                    }
                    if(dir[0] != 0 && mark[dir[0] - 1][dir[1]][wallNum] == null) {
                        deque.offerLast(new int[]{dir[0] - 1, dir[1]});
                    }
                    if(dir[1] != 0 && mark[dir[0]][dir[1] - 1][wallNum] == null) {
                        deque.offerLast(new int[]{dir[0], dir[1] - 1});
                    }
                    if(dir[1] != width - 1 && mark[dir[0]][dir[1] + 1][wallNum] == null) {
                        deque.offerLast(new int[]{dir[0], dir[1] + 1});
                    }
                }else {
                    if(!set.contains(dir[0] + ";" + dir[1])) {
                        wall.add(dir);
                        set.add(dir[0] + ";" + dir[1]);
                    }
                }
            }
            step++;
        }


        for (int i = 0; i < k; i++) {
            wallNum++;

            // 每次每个墙体获取周围最近的四个的[n-1]数值最小的 + 1作为初始步数
            for (int[] dir : wall) {
                Integer minStep = null;
                if(dir[0] < height - 1 && mark[dir[0] + 1][dir[1]][wallNum - 1] != null) {
                    minStep = minStep == null ? mark[dir[0] + 1][dir[1]][wallNum - 1] : Math.min(mark[dir[0] + 1][dir[1]][wallNum - 1], minStep);
                }
                if(dir[0] > 0 && mark[dir[0] - 1][dir[1]][wallNum - 1] != null) {
                    minStep = minStep == null ? mark[dir[0] - 1][dir[1]][wallNum - 1] : Math.min(mark[dir[0] - 1][dir[1]][wallNum - 1], minStep);
                }
                if(dir[1] < width - 1 && mark[dir[0]][dir[1] + 1][wallNum - 1] != null) {
                    minStep = minStep == null ? mark[dir[0]][dir[1] + 1][wallNum - 1] : Math.min(mark[dir[0]][dir[1] + 1][wallNum - 1], minStep);
                }
                if(dir[1] > 0 && mark[dir[0]][dir[1] - 1][wallNum - 1] != null) {
                    minStep = minStep == null ? mark[dir[0]][dir[1] - 1][wallNum - 1] : Math.min(mark[dir[0]][dir[1] - 1][wallNum - 1], minStep);
                }
                if(minStep != null) {
                    mark[dir[0]][dir[1]][wallNum] = minStep + 1;
                    deque.offerLast(dir);
                }
            }

            while((queueSize = deque.size()) != 0) {
                int[] dir = deque.pollFirst();

            }
        }



        return 0;
    }
}
