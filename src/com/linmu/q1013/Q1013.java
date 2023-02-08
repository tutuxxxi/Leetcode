package com.linmu.q1013;

import java.util.Arrays;

/**
 * @author by lijun
 * @since 2023/1/9 11:07
 */
public class Q1013 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();

        int range = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            range += arr[i];
            if(range * 3 == sum) {
                // 能够匹配
                int newRange = 0;
                for (int j = i + 1; j < length; j++) {
                    newRange += arr[j];
                    if(newRange == range) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
