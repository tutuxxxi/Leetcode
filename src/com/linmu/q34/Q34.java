package com.linmu.q34;

public class Q34 {
    public static void main(String[] args) {
        new Solution().searchRange(new int[]{
                5,7,7,8,8,10
        }, 6);

    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){

            int center = start + (end - start) / 2;


            if(nums[center] > target){
                end = center - 1;

            } else if(nums[center] < target){
                start = center + 1;

            } else{
                start = center;
                end = center;

                while(end + 1 < nums.length && nums[end + 1] == target){
                    end++;
                }
                while(start - 1 >= 0 && nums[start - 1] == target){
                    start--;
                }
                return new int[]{start, end};
            }
        }
        return new int[]{-1,-1};
    }
}
