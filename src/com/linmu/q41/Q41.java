package com.linmu.q41;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/6 3:52 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q41 {
    public static void main(String[] args) {
        new Solution().firstMissingPositive(new int[]{Integer.MAX_VALUE});
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
