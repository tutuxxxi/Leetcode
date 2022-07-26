package com.linmu.q517;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/29 8:52 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q517 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int findMinMoves(int[] machines) {
        int ans = 0, sum = 0, preSum = 0;
        sum = Arrays.stream(machines).sum();

        if(sum % machines.length != 0) {
            return -1;
        }

        int avg = sum / machines.length;
        for (int i = 0; i < machines.length; i++) {
            preSum += machines[i];
            ans = Math.max(ans, Math.max(machines[i] - avg, Math.abs(preSum - avg * (i + 1))));
        }
        return ans;
    }
}
