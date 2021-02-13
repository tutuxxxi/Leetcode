package com.linmu.q978;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/8 10:50
 * @description：leetcode q978
 * @modified By：
 * @version: 1.0
 */
public class Q978 {
    public static void main(String[] args) {
        new Solution().maxTurbulenceSize(new int[]{
                9,4,2,10,7,8,8,1,9
        });
    }
}

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;

        //遍历获得最长
        int status = 0;
        int length = 1;
        int maxLength = 1;

        //开始遍历
        for(int i = 1; i < len; i++){
            //当前状态
            int now = arr[i] - arr[i-1];

            if((status == 0 && now != 0) || (status > 0 && now < 0) || (status < 0 && now > 0)){
                length++;
            }else{
                //其余情况表现为结算长度
                maxLength = Math.max(maxLength, length);

                length = now == 0 ? 1 : 2;
            }
            
            status = now;
        }

        return Math.max(maxLength, length);
    }
}
