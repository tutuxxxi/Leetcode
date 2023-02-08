package com.linmu.q1658;

import java.util.Arrays;

/**
 * @author by lijun
 * @since 2023/1/30 16:43
 */
public class Q1658 {
    public static void main(String[] args) {
        //[5,2,3,1,1]
        //5
        System.out.println(new Solution().minOperations(new int[]{5, 2, 3, 1, 1}, 5));
    }
}

class Solution {
    public int minOperations(int[] nums, int x) {
        // 前缀和
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            nums[i] += nums[i - 1];
        }

        // 特殊情况
        int sum = nums[length - 1];
        if (sum < x) {
            return -1;
        }
        if (sum == x) {
            return length;
        }

        // 常规情况
        int ans = -1;

        // 取右边
        int require = sum - x;
        int index = Arrays.binarySearch(nums, require);
        if (index >= 0) {
            ans = length - index - 1;
        }
        for (int front = 0; front < length; front++) {
            // 如果要符合，则需要寻找一个index
            require = sum + nums[front] - x;
            index = Arrays.binarySearch(nums, require);
            if (index >= 0) {
                int step = (front + 1) + (length - index - 1);
                if (ans == -1) {
                    ans = step;
                } else {
                    ans = Math.min(step, ans);
                }
            }
        }
        return ans;
    }
}
