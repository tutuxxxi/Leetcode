package com.linmu.q561;

import java.util.Arrays;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/16 17:35
 * @description：leetcode q561
 * @modified By：
 * @version: 1.0
 */
public class Q561 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i<nums.length; i+=2){
            count += nums[i];
        }
        return count;
    }
}
