package com.linmu.q43;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/6 4:18 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q43 {
    public static void main(String[] args) {
        System.out.println(new Solution().multiply("1", "123456789"));;
    }
}


class Solution {
    public String multiply(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int baseNum = '0';
        int[] sum = new int[chars1.length + chars2.length - 1];

        for(int i = 0; i<chars1.length; i++) {
            for(int j = 0; j < chars2.length; j++) {
                sum[i + j] += ((chars1[i] - baseNum) * (chars2[j] - baseNum));
            }
        }

        for(int i = sum.length-1; i > 0; i--) {
            sum[i-1] += (sum[i] / 10);
            sum[i] %= 10;
        }

        StringBuilder res = new StringBuilder();
        for(int num : sum) {
            if(num != 0 || res.length() != 0){
                res.append(num);
            }
        }

        return res.length() == 0 ? "0" : res.toString();
    }
}
