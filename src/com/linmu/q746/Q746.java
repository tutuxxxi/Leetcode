package com.linmu.q746;

public class Q746 {
    public static void main(String[] args) {
        new Solution().minCostClimbingStairs(new int[]{
                1,2,3,4,5,6,7,8,9,10
        });
    }
}


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for(int i = 2; i < cost.length; i++){
            cost[i] += Math.min(cost[i-2], cost[i-1]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
