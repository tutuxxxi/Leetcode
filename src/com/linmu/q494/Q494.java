package com.linmu.q494;

import java.util.Arrays;

/**
 * @author ：xxx_
 * @date ：Created in 2021/6/8 8:51 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q494 {
    public static void main(String[] args) {
        new Solution().findTargetSumWays(new int[]{
                1,1,1,1,1
        }, 3);
    }
}


class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, nums.length-1, target);
    }

    public int findTargetSumWays(int[] nums, int index, int target){
        if(index == 0){
            int res = 0;
            if(nums[index] == target){
                res++;
            }
            if(nums[index] == -target){
                res++;
            }
            return res;
        }
        return findTargetSumWays(nums, index-1, target+nums[index]) +
                findTargetSumWays(nums, index-1, target-nums[index]);
    }
}