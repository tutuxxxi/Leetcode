package com.linmu.q16;

import java.util.Arrays;

public class Q16 {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[]{
                1,2,3,4,5,6,7,8,9,0,-1,123,1,-2123,12,-4124,12,-4,124,-124,12,-4,125,-1245
        }, 31));
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        if(nums.length == 3)
            return nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);

        //用于记录最近值
        int count = nums[0] + nums[1] + nums[2];

        //记录第二位和第三位
        int second = 0;
        int last = 0;

        //记录遍历期间的合值
        int sum;

        //固定首位在 0 ～ length-2 区间
        for(int first = 0; first<nums.length - 2; first++){

            second = first + 1;
            last = nums.length - 1;

            while (second != last){
                sum = nums[first] + nums[second] + nums[last];

                //这个遍历情况为最新的最近值
                if(Math.abs(sum - target) < Math.abs(count - target)) count = sum;

                if(sum > target) last--;
                else if(sum < target) second++;
                else return sum;
            }
        }

        return count;
    }
}
