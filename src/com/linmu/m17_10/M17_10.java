package com.linmu.m17_10;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/9 8:38 上午
 * @description：
 * @modified By：
 * @version:
 */
public class M17_10 {
    public static void main(String[] args) {
        new Solution().majorityElement(new int[]{
                1,2,5,9,5,9,5,5,5
        });
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int item = nums[0], count = 1;

        for(int i = 1; i<nums.length; i++){
            if(count == 0){
                item = nums[i];
                count = 1;
            }else{
                count += item == nums[i] ? 1 : -1;
            }
        }

        // 验证
        if(count != 0){
            count = 0;
            for(int num : nums){
                if(num == item){
                    count++;
                }
            }

            return count >= Math.round(nums.length/2.0) ? item : -1;
        }
        return -1;
    }
}
