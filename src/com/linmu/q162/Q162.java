package com.linmu.q162;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/15 8:53 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q162 {
    public static void main(String[] args) {
        new Solution().findPeakElement(new int[]{3,2,1});
    }
}


class Solution {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if((i == 0 || nums[i-1] < nums[i]) && (i == nums.length - 1 || nums[i] > nums[i + 1])) {
                return i;
            }
        }
        return -1;
    }
}
