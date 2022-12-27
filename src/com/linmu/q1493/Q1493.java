package com.linmu.q1493;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author by lijun
 * @since 2022/11/23 19:42
 */
public class Q1493 {
    public static void main(String[] args) {
        new Solution().longestSubarray(new int[] {0,1,1,1,0,1,1,0,1});
    }
}

class Solution {
    public int longestSubarray(int[] nums) {
        // 0-index 1-preLength 2-nextLength
        int max = Integer.MIN_VALUE;
        int preValue = 0;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num == 1) {
                length++;
            }else {
                max = Math.max(preValue + length, max);
                preValue = length;
                length = 0;
            }
        }
        return max == Integer.MIN_VALUE ? nums.length - 1 : Math.max(preValue + length, max);
    }
}

//  0 - - - 3 - - 2 -
// [0,1,1,1,0,1,1,0,1]


// 如果不存在则为最大的连续
