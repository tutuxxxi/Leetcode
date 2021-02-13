package com.linmu.q724;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/28 10:27
 * @description：leetcode q724
 * @modified By：
 * @version: 1.0
 */
public class Q724 {
    public static void main(String[] args) {
        new Solution().pivotIndex(new int[]{
                1, 7, 3, 6, 5, 6
        });
    }
}


class Solution {
    public int pivotIndex(int[] nums) {
        int count = 0;
        for(int i : nums){
            count += i;
        }

        int preCount = 0;
        for(int i = 0; i<nums.length; i++){
            if(preCount * 2 + nums[i] == count){
                return i;
            }
            preCount += nums[i];
        }

        return -1;
    }
}
