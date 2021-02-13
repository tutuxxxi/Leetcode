package com.linmu.q643;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/4 10:53
 * @description：q643
 * @modified By：
 * @version: 1.0
 */
public class Q643 {
    public static void main(String[] args) {

    }
}

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int maxSum = 0;

        for(int i = 0; i < k; i++){
            sum += nums[i];
        }

        maxSum = sum;

        for(int i = k; i < nums.length; i++){
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(sum, maxSum);
        }

        return 1.0 * maxSum / k;
    }
}
