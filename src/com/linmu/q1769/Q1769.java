package com.linmu.q1769;

/**
 * @author by lijun
 * @since 2022/12/2 8:42
 */
public class Q1769 {
    public static void main(String[] args) {
        new Solution().minOperations("1101011");
    }
}

class Solution {
    public int[] minOperations(String boxes) {
        int leftSum = 0;
        int rightSum = 0;
        int leftSize = 0;
        int rightSize = 0;

        int length = boxes.length();
        for (int i = 0; i < length; i++) {
            if(boxes.charAt(i) == '1') {
                rightSum += i;
                rightSize++;
            }
        }

        int[] ans = new int[length];
        int index = 0;
        do {
            if(boxes.charAt(index) == '1') {
                rightSize--;
                leftSize++;
            }
            ans[index] = leftSum + rightSum;
            rightSum -= rightSize;
            leftSum += leftSize;
        }while (++index < length);
        return ans;
    }
}
