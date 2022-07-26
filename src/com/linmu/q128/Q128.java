package com.linmu.q128;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/28 1:43 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q128 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int longestConsecutive(int[] nums) {
        int length = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (Integer integer : set) {
            // 当前为连续数列开头
            if(!set.contains(integer-1)) {
                int tempInteger = integer;
                while(set.contains(tempInteger)){
                    tempInteger++;
                }
                length = Math.max(length, tempInteger - integer);
            }
        }
        return length;
    }
}
