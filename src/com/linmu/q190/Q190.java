package com.linmu.q190;

import com.sun.deploy.util.StringUtils;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/29 9:14 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q190 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-123456));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE + (-123456) + 1));
        System.out.println(Integer.toBinaryString(0));
    }
}


class Solution {
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }
}