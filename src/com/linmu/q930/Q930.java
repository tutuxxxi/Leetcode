package com.linmu.q930;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/8 8:30 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q930 {
    public static void main(String[] args) {
        System.out.println(new Solution().numSubarraysWithSum(new int[]{
                0,0,0,0,0
        }, 0));
    }
}

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int ret = 0;
        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            ret += cnt.getOrDefault(sum - goal, 0);
        }
        return ret;
    }
}
