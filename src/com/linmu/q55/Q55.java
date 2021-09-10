package com.linmu.q55;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/9 3:13 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q55 {
    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{0,2,3}));
    }
}


class Solution {
    public boolean canJump(int[] nums) {
        boolean[] mark = new boolean[nums.length];
        mark[0] = true;

        for(int i = 1; i<nums.length; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(i - j <= nums[j] && mark[j]) {
                    mark[i] = true;
                    break;
                }
            }
        }

        return mark[nums.length-1];
    }
}
