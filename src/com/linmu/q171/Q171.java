package com.linmu.q171;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/30 9:24 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q171 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int res = 0;

        for(char c : chars){
            res = res * 26 + (c - 'A' + 1);
        }

        return res;
    }
}
