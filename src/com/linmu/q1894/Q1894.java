package com.linmu.q1894;

import java.util.Arrays;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/10 8:40 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1894 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int sum = Arrays.stream(chalk).sum();
        k %= sum;

        for (int i = 0; i < chalk.length; i++) {
            if(k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        return -1;
    }
}
