package com.linmu.q164;

import java.util.Arrays;

public class Q164 {
    public static void main(String[] args) {

    }
}



class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length <= 1)
            return 0;

        Arrays.sort(nums);

        int max = nums[1] - nums[0];
        for(int i = 1; i < nums.length-1; i++){
            max = (nums[i+1] - nums[i]) > max ? (nums[i+1] - nums[i]) : max;
        }

        return max;
    }
}