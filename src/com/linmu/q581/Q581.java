package com.linmu.q581;

/**
 * @author ：xxx_
 * @date ：Created in 2021/8/5 4:35 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q581 {
    public static void main(String[] args) {
        new Solution().findUnsortedSubarray(new int[]{
                2,6,4,8,10,9,15
        });
    }
}

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int preIndex = 0;
        int lastIndex = nums.length - 1;

        for(;preIndex < nums.length-1; preIndex++){
            if(nums[preIndex + 1] < nums[preIndex]){
                break;
            }
        }

        for(;lastIndex > 0; lastIndex--){
            if(nums[lastIndex - 1] > nums[lastIndex]){
                break;
            }
        }

        if(preIndex > lastIndex){
            return 0;
        }else{
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i = preIndex; i <= lastIndex; i++){
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
            }

            while(preIndex >= 0 && nums[preIndex] > min){
                preIndex--;
            }

            while(lastIndex < nums.length && nums[lastIndex] < max){
                lastIndex++;
            }

            return lastIndex - preIndex - 1;
        }
    }
}
