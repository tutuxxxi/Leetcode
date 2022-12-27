package com.linmu.q1701;

/**
 * @author by lijun
 * @since 2022/11/29 14:17
 */
public class Q1701 {
    public static void main(String[] args) {
        int[][] data = new int[][] {
                {1,2},
                {2,5},{4,3}
        };
        new Solution().averageWaitingTime(data);
    }
}

class Solution {
    public double averageWaitingTime(int[][] customers) {
        int waitTime = 0;
        int currentTime = 0;

        for (int[] customer : customers) {
            int arriveTime = customer[0];
            int cookTime = customer[1];

            if(currentTime > arriveTime) {
                waitTime += (currentTime - arriveTime);
            }else {
                currentTime = arriveTime;
            }
            waitTime += cookTime;
            currentTime += cookTime;
        }
        return (double) waitTime / customers.length;
    }
}
