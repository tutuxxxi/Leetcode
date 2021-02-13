package com.linmu.q665;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/7 08:41
 * @description：leetcode q665
 * @modified By：
 * @version: 1.0
 */
public class Q665 {
    public static void main(String[] args) {
        new Solution().checkPossibility(new int[]{
                3,4,2,3
        });
    }
}

class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i-1] <= nums[i]) {
                continue;
            }
            cnt++;
            if (i-2>=0 && nums[i-2] > nums[i]) {
                nums[i] = nums[i-1];
            }else {
                nums[i-1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}
