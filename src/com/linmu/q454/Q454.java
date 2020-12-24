package com.linmu.q454;

import java.util.HashMap;
import java.util.Map;

public class Q454 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];

                Integer temp = map.get(sum);
                map.put(sum, temp == null ? 1 : temp + 1);
            }
        }

        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                Integer temp = map.get(-(C[i] + D[j]));

                if (temp != null)
                    count += temp;
            }
        }

        return count;

    }
}