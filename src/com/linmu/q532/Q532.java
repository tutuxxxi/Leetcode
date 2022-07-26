package com.linmu.q532;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2022/6/16 13:28
 * @description：
 * @modified By：
 * @version:
 */
public class Q532 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));

        // 单调找数字
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(k == 0) {
                ans += entry.getValue() > 1 ? 1 : 0;
            }else {
                ans += map.containsKey(entry.getKey() + k) ? 1 : 0;
            }
        }
        return ans;
    }

    public int findPairs2(int[] nums, int k) {
        int n = nums.length, res = 0;
        Arrays.sort(nums);
        for (int i = 0, j = 0; i < n - 1 && j < n; i++) {
            //重复的不计算，如果相同nums[i-1]已经计算过了
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //需要j > i，有可能去重时导致i >= j
            while (j <= i) {
                j++;
            }
            //找到target 和方法二一样，只找nums[i] + k
            while (j < n && (nums[j] < nums[i] + k)) {
                j++;
            }
            //找到目标值
            if (j < n && nums[j] == nums[i] + k) {
                res++;
            }
        }
        return res;
    }
}
