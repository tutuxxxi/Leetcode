package com.linmu.q948;

import java.util.Arrays;

/**
 * @author by lijun
 * @since 2023/2/1 9:12
 */
public class Q948 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int frontIndex = 0;
        int backIndex = tokens.length - 1;

        int ans = 0;
        int score = 0;
        while(frontIndex <= backIndex) {

            // 如果够, 则前面进行买
            if(power >= tokens[frontIndex]) {
                power -= tokens[frontIndex++];
                score++;
                ans = Math.max(ans, score);
            } else {
                // 如果不够, 则后面进行卖
                if(score != 0) {
                    power += tokens[backIndex--];
                    score--;
                }else {
                    break;
                }
            }
        }
        return ans;
    }
}
