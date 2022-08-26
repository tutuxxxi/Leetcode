package com.linmu.q1464;

import java.util.Arrays;

/**
 * @author by lijun
 * @date 2022/8/26 8:35
 */
public class Q1464 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxProduct(int[] nums) {
        for (int index = 0; index < nums.length; index++) {
            nums[index] = nums[index] - index;
        }
        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length - 2];
    }
}
