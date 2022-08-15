package com.linmu.q1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author by lijun
 * @date 2022/8/4 8:28
 */
public class Q1403 {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = Arrays.stream(nums).sum(), subSum = 0;
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int index = nums.length - 1;
        while(index >= 0 && sum >= subSum) {
            subSum += nums[index];
            sum -= nums[index];
            ans.add(nums[index--]);
        }
        return ans;
    }
}
