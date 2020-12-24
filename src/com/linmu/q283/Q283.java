package com.linmu.q283;

import java.util.Arrays;
import java.util.Comparator;

public class Q283 {
    public static void main(String[] args) {

    }
}

class Solution {
    public void moveZeroes(int[] nums) {

        int start = 0;
        int end = nums.length-1;

        while(start < end){
            while (end > 0 && nums[end] == 0) {
                end--;

            }

            while(start < nums.length-1 && nums[start] != 0){
                start++;
            }

            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start++] ^= nums[end--];
        }

        if(nums[start] != 0){
            start++;
        }

        Arrays.sort(nums, 0, start);
    }
}
