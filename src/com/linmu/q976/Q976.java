package com.linmu.q976;

import java.util.Arrays;

public class Q976 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int largestPerimeter(int[] A) {
        if(A.length <= 2)
            return 0;

        Arrays.sort(A);

        //由后往前
        for(int i = A.length - 1; i >= 2; i--){
            if(A[i-2] + A[i-1] > A[i]){
                return A[i] + A[i-1] + A[i-2];
            }
        }

        return 0;
    }
}