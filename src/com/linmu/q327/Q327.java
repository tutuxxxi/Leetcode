package com.linmu.q327;

public class Q327 {
    public static void main(String[] args) {
        int[] a = new int[]{
                -2147483647,0,-2147483647,2147483647
        };

        System.out.println(new Solution().countRangeSum(a, -564, 3864));
    }
}


class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums.length == 0)
            return 0;

        if(lower > upper)
            return 0;


        int count = 0;
        long sum = 0;

        for(int i = 0; i<nums.length; i++){

            sum += nums[i];

            if(nums[i] >= lower && nums[i] <= upper)
                count++;

            for(int j = i + 1; j < nums.length; j++){
                sum += nums[j];

                if(sum >= lower && sum <= upper)
                    count++;
            }

            sum = 0;
        }
        return count;
    }
}
