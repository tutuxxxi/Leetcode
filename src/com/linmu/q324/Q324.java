package com.linmu.q324;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/9 8:47 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q324 {
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour(Integer.MAX_VALUE));
    }
}

class Solution {
    public boolean isPowerOfFour(int n) {
        double num = n;
        while(num > 1){
            num /= 4;
        }
        return num == 1;
    }
}
