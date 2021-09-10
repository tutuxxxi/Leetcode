package com.linmu.q50;

import java.math.BigDecimal;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/1 8:53 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q50 {
    public static void main(String[] args) {

    }
}

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            if(n == Integer.MIN_VALUE) {
                return 1/(myPow(x, Integer.MAX_VALUE) * x);
            }
            return 1/myPow(x, -n);
        }

        double temp = myPow(x, n/2);
        if(n % 2 == 0) {
            return temp * temp;
        }else {
            return temp * temp * x;
        }
    }
}
