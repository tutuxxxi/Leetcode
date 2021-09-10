package com.linmu.q1818;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/14 3:00 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1818 {
    public static void main(String[] args) {

    }
}


class Solution {
    int mod = (int)1e9+7;
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        long sum = 0, max = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i]) {
                int x = Math.abs(nums1[i] - nums2[i]);
                sum += x;
                int l = 0, r = nums1.length - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (sorted[mid] <= nums2[i]) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                int nd = Math.abs(sorted[r] - nums2[i]);
                if (r + 1 < nums1.length) {
                    nd = Math.min(nd, Math.abs(sorted[r + 1] - nums2[i]));
                }
                if (nd < x) {
                    max = Math.max(max, x - nd);
                }
            }
        }
        return (int)((sum - max) % mod);
    }
}
