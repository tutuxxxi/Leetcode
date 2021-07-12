package com.linmu.q275;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/12 8:24 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q275 {
    public static void main(String[] args) {
        new Solution().hIndex(new int[]{
                3,3,5
        });
    }
}


class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length;

        for(int i = length; i>0; i--){
            if(citations[length-i] >= i && (length == i || citations[length-i-1] <= i)){
                return i;
            }
        }

        return 0;
    }
}
