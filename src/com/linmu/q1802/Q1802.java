package com.linmu.q1802;

/**
 * @author by lijun
 * @since 2023/1/5 16:22
 */
public class Q1802 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxValue(4, 0, 4));
        // 0 0 0 0
        // 1 0 0 0
        // 2 1 0 0
    }
}


class Solution {
    public int maxValue(int length, int index, int maxSum) {
        maxSum -= length;

        // 最大扩散次数
        int leftLength = index + 1;
        int rightLength = length - index;
        int maxSpeedLength = Math.max(leftLength, rightLength);
        int ans = 0, sum = 0;
        for (int i = 1; i <= maxSpeedLength; i++) {
            int leftSum = getNum(i, leftLength);
            int rightSum = getNum(i, rightLength);
            sum = leftSum + rightSum - (ans + 1);
            if(sum > maxSum) {
                break;
            }
            ans++;
        }

        if(sum < maxSum) {
            ans += (maxSum - sum) / length;
        }
        return ans + 1;
    }

    /**
     * 累加公式 n * (n + 1) / 2
     *
     * @param speedLength
     * @param maxLength
     * @return
     */
    private int getNum(int speedLength, int maxLength) {
        int num = speedLength * (speedLength + 1) / 2;
        if(speedLength < maxLength) {
            return num;
        }
        return num - getNum(speedLength - maxLength, Integer.MAX_VALUE);
    }
}

//

