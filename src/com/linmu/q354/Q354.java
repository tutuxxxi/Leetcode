package com.linmu.q354;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/4 11:18
 * @description：
 * @modified By：
 * @version:
 */
public class Q354 {
    public static void main(String[] args) {
        new Solution().maxEnvelopes(new int[][]{
                {2,100},
                {3,200},
                {4,300},
                {5,400},
                {5,500},
                {5,250},
                {6,370},
                {6,360},
                {7,380}
        });
    }
}

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0){
            return 0;
        }
        
        Arrays.sort(envelopes, (int[] arr1, int[] arr2) -> {
            if (arr1[0] != arr2[0]){
                return arr1[0] - arr2[0];
            }else {
                return arr2[1] - arr1[1];
            }
        });


        int[] dp = new int[envelopes.length];
        //初始化数组dp的每个值为1
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                //如果当前值envelopes[i]大于envelopes[j]，说明envelopes[i]可以和
                //envelopes[j]结尾的上升序列构成一个新的上升子序列
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    //记录构成的最大值
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}