package com.linmu.q263;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/10 9:18 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q263 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isUgly(int n) {
        short[] nums = {2,3,5};
        for(int i = 0; i<3; i++){
            while(n % nums[i] == 0){
                n /= nums[i];
            }
        }
        return n == 1 || n == -1;
    }
}
