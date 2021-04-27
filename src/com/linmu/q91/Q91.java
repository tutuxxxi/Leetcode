package com.linmu.q91;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/21 10:23 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q91 {
    public static void main(String[] args) {
    }
}

class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        char[] chars = s.toCharArray();

        if(chars[0] != '0'){
            dp[0] = 1;
        }

        for(int i = 0; i < chars.length; i++){
            //对于每一个位置，只会存在三种情况： 0次匹配， 1次匹配， 2次匹配
            int count = 0;
            boolean mark = false;

            //作为单数字匹配
            if(chars[i] != '0'){
                count++;
            }

            //作为双数字匹配
            if(i != 0 && chars[i-1] != '0' && Integer.valueOf(chars[i-1] + "" + chars[i]) <= 26){
                count++;
                mark = true;
            }

            switch (count){
                case 0:
                    return 0;
                case 1:
                    dp[i+1] = mark ? dp[i-1] : dp[i];
                    break;
                case 2:
                    //此处理应进行翻倍
                    dp[i+1] = dp[i-1] * 2;
                    dp[i+1] += (dp[i] - dp[i-1]);
                    break;
            }
        }
        return dp[chars.length];
    }
}
