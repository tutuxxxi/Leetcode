package com.linmu.q17;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q17 {
    public static void main(String[] args) {
        new Solution().letterCombinations("23");
    }
}


class Solution {

    private static final char[][] CHARS = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    List<String> list = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if(digits != null && !digits.equals("")){
            list.add("");

            for(char c : digits.toCharArray()){
                add(Integer.parseInt(Character.toString(c))-2);
            }
        }
        return list;
    }


    /**
     * 传入一个index， 对已存在的字符串进行乘积
     * @param index
     */
    public void add(int index){
        int length = list.size();
        Queue<String> queue = (Queue<String>) list;

        for(int i = 0; i<length; i++) {
            String poll = queue.poll();

            for(int j = 0; j<CHARS[index].length; j++){
                queue.offer(poll + CHARS[index][j]);
            }
        }
    }
}



/*

 */
