package com.linmu.q1052;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/23 10:34
 * @description：leetcode q1052
 * @modified By：
 * @version: 1.0
 */
public class Q1052 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int x) {
        int sum = 0, len = customers.length;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0){
                sum += customers[i];
                customers[i] = 0;
            }
        }
        int num = customers[0];
        int maxval = customers[0];
        for (int i = 1; i < len; i++){
            if (i < x) {
                num = num + customers[i];
            } else {
                num = num + customers[i] - customers[i - x];
            }
            maxval = Math.max(maxval, num);
        }

        return (sum + maxval);
    }
}