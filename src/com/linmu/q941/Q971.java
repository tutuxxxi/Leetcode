package com.linmu.q941;


/*
给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。

让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：

A.length >= 3
在 0 < i < A.length - 1 条件下，存在 i 使得：
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]

 */

public class Q971 {
    public static void main(String[] args) {

        int[] test = {1,2,3,4,5,6,5,1};
        System.out.println(new Solution().validMountainArray(test));
    }
}

class Solution {
    public boolean validMountainArray(int[] A) {
        if(A.length < 3)
            return false;

        int temp = A[0];
        int signal = 0;  //标识状态值是否被改变
        int status = 1;  //标识当前的状态，是位于递增还是递减
        for(int i = 1; i < A.length; i++){
            if(temp < A[i]){
                if(i == A.length-1)
                    return false;

                //前面在递减，而此处递增
                if(status == 0)
                    return false;

            }else if(temp > A[i]){
                if(i == 1)
                    return false;

                //前面在递增
                if(status == 1){
                    //状态未被切换
                    if(signal == 0){
                        status = 0;
                        signal = 1;
                    }else{
                        //状态已被切换过
                        return false;
                    }
                }
            }else
                return false;

            temp = A[i];
        }

        return true;
    }
}
