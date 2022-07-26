package com.linmu.q212;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/16 8:33 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q212 {
    public static void main(String[] args) {
        new Solution().findWords(new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        }, new String[] {
                "eat", "oath"
        });
    }
}


class Solution {
    boolean[][] mark;
    char[][] board;
    int[][] dir = new int[][]{
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    char[] chars;


    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        List<String> res = new ArrayList<>();
        MyTrie build = build(words);




        return res;
    }
//
//    public boolean exist(char[][] board, String word) {
//        mark = new boolean[board.length][board[0].length];
//        chars = word.toCharArray();
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                if(board[i][j] == chars[0]) {
//                    mark[i][j] = true;
//                    if(exists( i, j, 1)) {
//                        return true;
//                    }
//                    mark[i][j] = false;
//                }
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 能否在x，y周围找到index位置字符
//     * @param x
//     * @param y
//     * @param index
//     * @return
//     */
//    private boolean exists(int x, int y, int index) {
//        if(index == chars.length) {
//            return true;
//        }
//
//        for(int i = 0; i < dir.length; i++) {
//            int newX = x + dir[i][0];
//            int newY = y + dir[i][1];
//            if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
//                if(!mark[newX][newY] && board[newX][newY] == chars[index]) {
//                    mark[newX][newY] = true;
//                    if(exists(newX, newY, index + 1)) {
//                        return true;
//                    }
//                    mark[newX][newY] = false;
//                }
//            }
//        }
//        return false;
//    }





    class MyTrie{
        public boolean mark;
        public MyTrie[] words = new MyTrie[26];
    }


    private MyTrie build(String[] words) {
        MyTrie res = new MyTrie();

        for (String word : words) {
            char[] chars = word.toCharArray();
            MyTrie operator = res;

            for (char c : chars) {
                int index = c - 'a';
                if(operator.words[index] == null) {
                    operator.words[index] = new MyTrie();
                }
                operator = operator.words[index];
            }
            operator.mark = true;
        }

        return res;
    }
}
