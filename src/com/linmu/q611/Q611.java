package com.linmu.q611;

import java.util.Arrays;

/**
 * @author ：xxx_
 * @date ：Created in 2021/8/4 8:39 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q611 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        for(int i = 0; i<nums.length-2; i++){
            for(int j = i + 1; j < nums.length-1; j++){
                int high = nums[i] + nums[j];
                for(int k = j + 1; k < nums.length && nums[k] < high; k++){
                    count ++;
                }
            }
        }

        return count;
    }
}
