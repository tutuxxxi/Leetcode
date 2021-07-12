package com.linmu.q1720;

/**
 * @author ：xxx_
 * @date ：Created in 2021/5/6 9:22 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1720 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];

        res[0] = first;

        for(int i = 1; i<res.length; i++){
            res[i] = res[i-1] ^ encoded[i-1];
        }

        return res;
    }
}
