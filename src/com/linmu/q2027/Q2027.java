package com.linmu.q2027;

/**
 * @author by lijun
 * @since 2022/12/27 15:35
 */
public class Q2027 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int minimumMoves(String s) {
        // 滑动窗口
        int length = s.length();
        int preIndex = 0;
        int ans = 0;

        while(preIndex < length) {
            while(preIndex < length && s.charAt(preIndex) == 'O') {
                preIndex++;
            }
            if(preIndex == length) {
                break;
            }
            ans++;
            preIndex += 3;
        }

        return ans;
    }
}
