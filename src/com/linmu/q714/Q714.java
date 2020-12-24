package com.linmu.q714;

public class Q714 {
    public static void main(String[] args) {
        new Solution().maxProfit(new int[]{
                1,3,7,5,10,3
        }, 3);

    }
}

class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length < 2) {
            return 0;
        }

        int count = 0;
        int minPrice = prices[0];

        for(int i = 1; i<prices.length; i++){

            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if(prices[i] - minPrice > fee){
                count += prices[i] - minPrice - fee;
                minPrice = prices[i] - fee;
            }
        }
        return count;
    }

}

