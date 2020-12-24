package com.linmu.q514;

public class Q514 {
    public static void main(String[] args) {
        System.out.println(new Solution().findRotateSteps("abcde", "ade"));
    }
}

class Solution {
    public int findRotateSteps(String ring, String key) {

        char[] ringChars = ring.toCharArray();
        char[] keyChars = key.toCharArray();
        int[][] dp = new int[ringChars.length][keyChars.length];

        for(int keyIndex = 0; keyIndex < keyChars.length; keyIndex++){
            for(int ringIndex = 0; ringIndex < ringChars.length; ringIndex++){

                if(keyChars[keyIndex] != ringChars[ringIndex])
                    dp[ringIndex][keyIndex] = 10000;
                else{
                    if(keyIndex == 0){
                        //表示当前只是第一个匹配字符位置

                        //行走的步数 = ringIndex
                        dp[ringIndex][keyIndex] = Math.min(ringIndex, ringChars.length - ringIndex);
                    }else{
                        //表示当前不是第一个匹配字符，则步数需要通过转移公式获得

                        //行走步数
                        dp[ringIndex][keyIndex] = 10000;

                        //遍历整个能匹配keyIndex-1字串的dp数组，取出距离+dp数据和最低的数字
                        for(int i = 0; i<ringChars.length; i++){
                            int step = Math.min(Math.abs(i-ringIndex), Math.min(ringIndex + ringChars.length - i, i + ringChars.length - ringIndex));
                            dp[ringIndex][keyIndex] = Math.min(dp[ringIndex][keyIndex], step + dp[i][keyIndex-1]);
                        }
                    }
                }
            }
        }

        int min = 10000;
        for(int i = 0; i<ringChars.length; i++)
            min = Math.min(min, dp[i][keyChars.length-1]);

        min += keyChars.length;

        return min;
    }
}
