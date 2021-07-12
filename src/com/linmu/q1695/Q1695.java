package com.linmu.q1695;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/9 8:55 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1695 {
    public static void main(String[] args) {
        new Solution().maximumUniqueSubarray(new int[]{
                4,2,4,5,6
        });
    }
}

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int max = 0, count = 0;
        int front = 0, to = 0;

        count = nums[0];
        map.put(nums[0], 0);

        while(to < nums.length-1){
            // 右移
            to++;

            // 重复
            if(map.containsKey(nums[to])){
                // 统计
                max = Math.max(count, max);

                // 左指针右移
                Integer target = map.get(nums[to]);
                map.remove(nums[to]);

                while(front <= target){
                    count -= nums[front++];
                }
            }

            count += nums[to];
            map.put(nums[to], to);
        }

        return Math.max(count, max);
    }
}
