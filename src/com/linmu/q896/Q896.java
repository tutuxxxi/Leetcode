package com.linmu.q896;

import javax.sound.midi.Track;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/28 11:20
 * @description：
 * @modified By：
 * @version:
 */
public class Q896 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isMonotonic(int[] A) {
        if(A.length <= 2){
            return true;
        }

        int status = A[1] - A[0];

        for (int i = 2; i < A.length; i++) {
            //只有不同时去考虑
            if(A[i] != A[i-1]){
                if(status == 0){
                    //此时列表无状态， 赋予状态
                    status = A[i] - A[i-1];
                }else if((status < 0 && A[i] > A[i-1]) || (status > 0 && A[i] < A[i-1])){
                    return false;
                }
            }
        }

        return true;
    }
}