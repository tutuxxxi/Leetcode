package com.linmu.q674;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/24 11:35
 * @description：leetcode q674
 * @modified By：
 * @version: 1.0
 */
public class Q674 {
    public static void main(String[] args) {
        new Solution().findLengthOfLCIS(new int[]{
                1,3,5,4,7
        });
    }
}

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int max = 0, count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i-1]){
                //不再递增
                max = Math.max(max, count);
                count = 1;
            }else{
                count++;
            }
        }

        return Math.max(max, count);
    }
}

