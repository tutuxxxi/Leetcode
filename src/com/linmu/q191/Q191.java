package com.linmu.q191;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/22 9:03 上午
 * @description：
 * @modified By：
 * @version:
 */

public class Q191 {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}

class Solution {
    /**
     * 返回n的二进制表达式中1的个数
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        if(n < 0){
            n += Integer.MAX_VALUE + 1;
            res++;
        }

        while(n != 0){
            res += n % 2;
            n /= 2;
        }

        return res;
    }
}
