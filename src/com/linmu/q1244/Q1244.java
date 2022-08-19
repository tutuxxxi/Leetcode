package com.linmu.q1244;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by lijun
 * @date 2022/8/18 14:55
 */
public class Q1244 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxEqualFreq(new int[]{1,1}));
    }
}


class Solution {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int index = nums.length - 1;
        while(true) {
            if(check(map)) {
                return index + 1;
            }
            Integer integer = map.get(nums[index]) - 1;
            if(integer == 0) {
                map.remove(nums[index--]);
            }else {
                map.put(nums[index--], integer);
            }
        }
    }

    public boolean check(Map<Integer, Integer> map) {
        if(map != null && !map.isEmpty()) {
            // 判断values中是否存在 n-1个k和1个k+1
            Collection<Integer> values = map.values();
            int value1 = -1, value2 = -1;
            int size1 = 0;

            for (Integer value : values) {
                if(value1 == -1 || value2 == -1) {
                    // 占位置
                    if(value1 == -1) {
                        value1 = value;
                        size1++;
                    }else {
                        if(value == value1) {
                            size1++;
                        }else {
                            value2 = value;
                        }
                    }
                }else {
                    // 增加
                    if(value != value1 && value != value2) {
                        return false;
                    }
                    if(size1 == 1) {
                        if(value == value2) {
                            value2 = value1;
                            value1 = value;
                        }
                    }
                    if(value == value2) {
                        return false;
                    }
                    size1++;
                }
            }


            if(value1 == -1) {
                return false;
            }
            if(value2 == -1 && size1 != 1) {
                return false;
            }
        }
        return true;
    }
}
