package com.linmu.q529;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q529 {
    public static void main(String[] args) {
        char[][] map = new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };

        int[] click = new int[]{0,0};

        for(char[] i : new Solution().updateBoard(map, click)){
            System.out.println(Arrays.toString(i));
        }
    }
}

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {

        switch (board[click[0]][click[1]]){
            case 'E':

                int[][] dir = new int[][]{
                    {1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}
                };

                //开始递归
                boolean[][] mark = new boolean[board.length][board[0].length];
                Queue<int[]> queue = new LinkedList<>();

                queue.offer(new int[]{click[0], click[1]});
                mark[click[0]][click[1]] = true;

                while(!queue.isEmpty()){

                    for(int i = 0; i<queue.size(); i++){

                        int[] poll = queue.poll();

                        int count = 0;
                        for(int j = 0; j<8; j++){
                            int x = poll[0] + dir[j][0];
                            int y = poll[1] + dir[j][1];

                            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length){
                                if(board[x][y] == 'M')
                                    count++;
                            }
                        }

                        if(count != 0){
                            //周围有炸弹 则进行值替换
                            board[poll[0]][poll[1]] = (char)(count + '0');
                        }else{
                            //周围没有炸弹

                            board[poll[0]][poll[1]] = 'B';

                            for(int j = 0; j<8; j++){
                                int x = poll[0] + dir[j][0];
                                int y = poll[1] + dir[j][1];

                                if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && mark[x][y] == false){
                                    //对所有没有超过地图范围且未被遍历的点进行存入
                                    mark[x][y] = true;
                                    queue.offer(new int[]{x ,y});
                                }
                            }

                        }
                    }

                }
                break;


            case 'M':
                board[click[0]][click[1]] = 'X';
                return board;
        }
        return board;
    }
}
