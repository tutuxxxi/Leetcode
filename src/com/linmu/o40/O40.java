package com.linmu.o40;

import java.util.Arrays;

public class O40 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == arr.length)
            return arr;

        Arrays.sort(arr);

        return Arrays.copyOf(arr, k);
    }
}


