package com.linmu.q29;

/**
 * @author ：xxx_
 * @date ：Created in 2021/8/4 9:46 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q29 {
    public static void main(String[] args) {
        System.out.println(new Solution().divide(Integer.MIN_VALUE, 2));;
    }
}

class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0 || divisor == 1) {
            return dividend;
        }
        if(divisor == -1){
            if(dividend>Integer.MIN_VALUE) {
                return -dividend;
            }
            return Integer.MAX_VALUE;
        }

        boolean mark = false;

        long temp1 = dividend;
        long temp2 = divisor;

        if(temp1 < 0){
            mark = !mark;
            temp1 = -temp1;
        }

        if(temp2 < 0){
            mark = !mark;
            temp2 = -temp2;
        }

        int res = div(temp1, temp2);

        return mark ? -res : res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res;
    }

    private int div(long a, long b) {
        if(a < b) {
            return 0;
        }

        long count = 1;
        long temp = b;
        while( temp << 1 <= a){
            count = count << 1;
            temp = temp << 1;
        }

        return (int) (count + div(a - temp, b));
    }
}
