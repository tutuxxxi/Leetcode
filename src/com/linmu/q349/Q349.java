package com.linmu.q349;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Q349 {
    public static void main(String[] args) {
        new Solution().intersection(new int[]{
                1,2,2,1
        }, new int[]{
                2,2
        });

    }
}


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for(int i : nums1)
            set.add(i);

        int length = nums2.length;
        for (int i = 0; i < nums2.length; i++) {
            if(!set.contains(nums2[i])){
                nums2[i] = Integer.MIN_VALUE;
                length--;
            }else{
                set.remove(nums2[i]);
            }
        }

        Arrays.sort(nums2);
        return Arrays.copyOfRange(nums2, nums2.length - length, nums2.length);

    }
}