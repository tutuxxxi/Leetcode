package com.linmu.q633;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/28 12:57 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q633 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        for(int i = 0; i<1000000; i++){
            solution.judgeSquareSum(i);
        }
    }
}

class Solution {
    public boolean judgeSquareSum(int c) {
        int max = (int)Math.sqrt(c/2.0);
        for(int i = 0; i<=max; i++){
            int target = (int) Math.sqrt(c - (i * i));
            if(target * target + i * i == c){
                System.out.println(i + "*" + i + " + " + target + "*" + target + " = " + c);
                return true;
            }
        }
        return false;
    }
}
