package com.linmu.q485;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/15 10:24
 * @description：leetcode q485
 * @modified By：
 * @version: 1.0
 */
public class Q485 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0;
        int length = 0;

        for(int num : nums){
            if(num == 0){
                maxLength = Math.max(length, maxLength);
                length = 0;
            }else{
                length++;
            }
        }

        return Math.max(length, maxLength);
    }
}