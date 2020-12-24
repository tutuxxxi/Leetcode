package com.linmu.q922;

import java.util.Arrays;

public class Q922 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{
                1,2,3,4,5,6,7,8,9,10
        })));
    }
}


class Solution {
//    public int[] sortArrayByParityII(int[] A) {
//
//        //遍历偶数位
//        for(int i = 0; i<A.length; i+=2){
//
//            //当前位不为偶数
//            if(A[i] % 2 != 0){
//
//                //寻找一个位于奇数位的偶数交换
//                int j = i + 1;
//
//                while (A[j] % 2 != 0){
//                    if(j == A.length-1)
//                        j = 1;
//                    else
//                        j += 2;
//                }
//
//                A[i] ^= A[j];
//                A[j] ^= A[i];
//                A[i] ^= A[j];
//            }
//
//        }
//
//        return A;
//
//    }

    public int[] sortArrayByParityII(int[] A) {
        //双指针优化

        int i = 0, j = 1;

        while (i <= A.length-2 && j <= A.length-1){

            while (A[i] % 2 == 0){
                i += 2;
                if(i > A.length-2)
                    return A;
            }


            while(A[j] % 2 == 1){
                j += 2;
                if(j > A.length - 1)
                    return A;
            }

            A[i] ^= A[j];
            A[j] ^= A[i];
            A[i] ^= A[j];
        }

        return A;
    }
}
