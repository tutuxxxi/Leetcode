package com.linmu.q628;

import java.util.Arrays;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/20 18:24
 * @description：三个数的最大乘积
 * @modified By：
 * @version: 1.0
 */
public class Q628 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return Math.max(nums[length - 1] * nums[length - 2] * nums[length - 3],
                nums[length - 1] * nums[0] * nums[1]);
    }
}
