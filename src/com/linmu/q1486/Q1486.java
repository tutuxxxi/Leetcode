package com.linmu.q1486;

/**
 * @author ：xxx_
 * @date ：Created in 2021/5/7 1:42 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1486 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int xorOperation(int n, int start) {
        int res = start;

        for(int i = 1; i<n; i++){
            res ^= (start + 2 * i);
        }

        return res;
    }
}

// start ^ (start + 2 * i)