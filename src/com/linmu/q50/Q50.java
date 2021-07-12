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
        BigDecimal base = new BigDecimal(String.valueOf(x));
        BigDecimal res = base;

        if(n > 0){
            for(int i = 1; i<n; i++){
                res = res.multiply(base);
            }
        }else{
            for(int i = 0; i>n; i--){
                res = res.divide(base);
            }
        }

        return res.doubleValue();
    }
}
