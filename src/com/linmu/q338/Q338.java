package com.linmu.q338;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/3 12:44
 * @description：
 * @modified By：
 * @version:
 */
public class Q338 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] countBits(int num) {
        // 基本思路：进位
        // 进位后高位数字多一个1，低位从零开始进位 为前面的复制

        //定义一个返回
        int[] res = new int[num+1];

        //对每一个数字进行遍历
        for (int i = 1; i <= num; ) {
            int temp = i;
            for(int j = 0; j < temp && i <= num; j++, i++){
                res[i] = 1 + res[j];
            }
        }

        return res;
    }
}
