package com.linmu.q45;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/7 8:54 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q45 {
    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2,3,1,1,4}));
    }
}

class Solution {
    public int jump(int[] nums) {
        int[] mark = new int[nums.length];
        mark[0] = 0;

        for(int i = 1; i < nums.length; i++) {
            mark[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < nums.length - 1; i++) {
            int step = mark[i] + 1;
            for(int j = 1; j <= nums[i] && j < nums.length - i; j++) {
                mark[i + j] = Math.min(mark[i + j], step);
            }
        }

        return mark[nums.length-1];
    }
}
