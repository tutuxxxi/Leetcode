package com.linmu.q1608;

import java.util.Arrays;

/**
 * @author by lijun
 * @since 2023/1/20 13:16
 */
public class Q1608 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length;
        if(nums[0] >= length) {
            return length;
        }

        for (int i = 1; i < length; i++) {
            int num = length - i;
            if(nums[i] >= num && nums[i - 1] < num) {
                return num;
            }
        }
        return -1;
    }
}
