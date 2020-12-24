package com.linmu.q1035;

public class Q1035 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxUncrossedLines(new int[]{
               1,4,2
        }, new int[]{
                1,2,4
        }));
    }
}


class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        /*
                动态规划；
                    设置dp数组，定义dp[x][y] 表示A的前x个数字和B的前y个数字的最大连接数量

                    dp[0][0] = 0;

                    当A[x] == B[y]时，dp[x][y] = 1 + dp[x-1][y-1];
                    当A[x] != B[y]时，dp[x][y] = max( dp[x-1][y], dp[x][y-1])

                        解释： 当前可连线，则最大连线数 = 1 + 前面的最大连线数
                              当前不可连线，则求两个子情况的最大连接数（可能A的x被前面的连了，也可能B的y被前面连了）



         */


        int[][] dp = new int[A.length+1][B.length+1];

        //x = 0 和 y = 0的情况已经被默认初始化为0了，不再手动赋值

        for(int i = 1; i <= A.length; i++){
            for (int j = 1; j <= B.length; j++) {

                if(A[i-1] == B[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
            }
        }


        return dp[A.length][B.length];
    }
}