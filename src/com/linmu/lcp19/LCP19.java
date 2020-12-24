package com.linmu.lcp19;

public class LCP19 {
    public static void main(String[] args) {
        new Solution().minimumOperations("rrryyyrryyyrr");
    }
}


class Solution {
    public int minimumOperations(String leaves) {
        //rrr yyy rr yyy rr
        /*
            状态值： 0：左边r      1：y     2：右边r
         */

        char[] chars = leaves.toCharArray();
        int[][] dp = new int[chars.length][3];

        //左边第一个变为0的步数
        dp[0][0] = chars[0] == 'r' ? 0 : 1;
        //左边第一个不能为1 2
        dp[0][1] = dp[0][2] = Integer.MAX_VALUE;


        for(int i = 1; i < chars.length; i++){
            //对每一个进行遍历

            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
            dp[i][2] = Integer.MAX_VALUE;

            int toRed = (chars[i] == 'r' ? 0 : 1);
            int toYellow = (chars[i] == 'y' ? 0 : 1);

            //前一个能够成为左边的r
            if(dp[i-1][0] != Integer.MAX_VALUE){
                dp[i][0] = Math.min(dp[i][0], dp[i-1][0] + toRed);
                dp[i][1] = Math.min(dp[i][1], dp[i-1][0] + toYellow);
            }

            //前一个能够成为y
            if(dp[i-1][1] != Integer.MAX_VALUE){
                dp[i][1] = Math.min(dp[i][1], dp[i-1][1] + toYellow);
                dp[i][2] = Math.min(dp[i][2], dp[i-1][1] + toRed);
            }

            if(dp[i-1][2] != Integer.MAX_VALUE){
                dp[i][2] = Math.min(dp[i][2], dp[i-1][2] + toRed);
            }
        }

        return dp[chars.length-1][2];
    }
}