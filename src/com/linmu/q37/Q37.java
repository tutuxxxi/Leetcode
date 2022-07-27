package com.linmu.q37;


import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xxx_
 * @date ：Created in 2021/8/5 2:44 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q37 {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        new Solution().solveSudoku(new char[][]{
        {'.','.','9','7','4','8','.','.','.'},
        {'7','.','.','.','.','.','.','.','.'},
        {'.','2','.','1','.','9','.','.','.'},
        {'.','.','7','.','.','.','2','4','.'},
        {'.','6','4','.','1','.','5','9','.'},
        {'.','9','8','.','.','.','3','.','.'},
        {'.','.','.','8','.','3','.','2','.'},
        {'.','.','.','.','.','.','.','.','6'},
        {'.','.','.','2','7','5','9','.','.'}
        });
        System.out.println(System.currentTimeMillis() - l);
    }
}

class Solution {

    private char[][] board;
    private Set<Character>[][] mark;

    public void solveSudoku(char[][] board) {
        this.board = board;
        mark = new Set[3][9];

        // 初始化set并保存各个set信息
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(mark[0][i] == null){
                    mark[0][i] = new HashSet<>();
                }
                if(mark[1][j] == null){
                    mark[1][j] = new HashSet<>();
                }
                if(mark[2][i/3*3 + j/3] == null){
                    mark[2][i/3*3 + j/3] = new HashSet<>();
                }

                if(board[i][j] != '.'){
                    mark[0][i].add(board[i][j]);
                    mark[1][j].add(board[i][j]);
                    mark[2][i/3*3 + j/3].add(board[i][j]);
                }
            }
        }

        // 题目保证有解，这里不用判断true或false
        fill(0, 0);
    }

    /**
     * 在x y处尝试填入字符，如果无法填入则返回false
     * @param x
     * @param y
     * @return
     */
    private boolean fill(int x, int y){
        while(board[x][y] != '.'){
            y++;

            if(y == 9){
                x++;
                y = 0;
            }

            if(x == 9){
                return true;
            }
        }


        for(char c = '1'; c <= '9'; c++){
            if(!mark[0][x].contains(c) && !mark[1][y].contains(c) && !mark[2][x/3*3 + y/3].contains(c)){
                // 可以填入 则填入
                mark[0][x].add(c);
                mark[1][y].add(c);
                mark[2][x/3*3 + y/3].add(c);
                board[x][y] = c;

                // 递归
                if(fill(x, y)){
                    return true;
                }

                mark[0][x].remove(c);
                mark[1][y].remove(c);
                mark[2][x/3*3 + y/3].remove(c);
                board[x][y] = '.';
            }
        }

        // 遍历完都没办法，就返回false
        return false;
    }

}
