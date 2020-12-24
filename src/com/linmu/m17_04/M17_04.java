package com.linmu.m17_04;

import java.util.Arrays;

public class M17_04 {
    public static void main(String[] args) {

    }
}

//class Solution {
//    public int missingNumber(int[] nums) {
//        if(nums.length == 0)
//            return 0;
//
//        Arrays.sort(nums);
//
//        if(nums[0] != 0)
//            return 0;
//
//        for(int i = 1; i<nums.length; i++){
//            if(nums[i] != nums[i - 1]  + 1)
//                return nums[i-1] + 1;
//        }
//
//        return nums[nums.length - 1] + 1;
//    }
//}

class Solution {
    public int missingNumber(int[] nums) {
/*
        异或的性质 ： A ^ B ^ B = A

        因此对从0 - num.length都进行异或
        再对nums[0] - nums[nums.length - 1]进行异或

        就能得出nums中缺失的数字（res再对原来的值进行异或，但是A ^ 0 = A, 则可以省去）
 */
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= nums.length;

        //res再对原来的值进行异或，但是A ^ 0 = A, 则可以省去
        return res;
    }
}
