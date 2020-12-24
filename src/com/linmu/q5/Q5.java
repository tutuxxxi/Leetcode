package com.linmu.q5;

public class Q5 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("adadad"));
    }
}

class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        int maxStart = 0;
        int maxEnd = 0;

        boolean[][] DP = new boolean[length][length];


        //DP转移方程为 DP[i][j] = DP[i+1][j-1] && charAt(i) == charAt(j)
        // 从对角线往右上角推
        for(int i = 0; i< length; i++){

            for(int j = 0; j<length-i; j++){

                if(i == 0)
                    DP[j][j] = true;
                else if(i == 1)
                    DP[j][j+1] = s.charAt(j+1) == s.charAt(j);
                else
                    DP[j][j+i] = DP[j+1][j+i-1] && s.charAt(j) == s.charAt(j+i);

                if(DP[j][j+i]){
                    if(i > maxEnd - maxStart){
                        maxEnd = j+i;
                        maxStart = j;
                    }
                }
            }

        }


        return s.substring(maxStart, maxEnd+1);
    }
}
