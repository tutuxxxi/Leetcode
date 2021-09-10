package com.linmu.q1877;

import java.util.Arrays;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/20 10:24 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1877 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int res = 0;
        for(int i = 0; i < length / 2; i++){
            res = Math.max(res, nums[length - i - 1] + nums[i]);
        }
        return res;
    }
}
