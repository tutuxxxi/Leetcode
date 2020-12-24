package com.linmu.q1356;

import apple.laf.JRSUIUtils;

import java.util.*;

public class Q1356 {

    public static void main(String[] args) {
    }
}



class Solution {
    public int[] sortByBits(int[] arr) {
        if(arr.length == 0)
            return arr;

        for(int i = 0; i<arr.length; i++){
            arr[i] += Integer.bitCount(arr[i]) * 100000;
        }

        Arrays.sort(arr);

        int[] nums = new int[arr.length];

        for(int i = 0; i<arr.length; i++)
            nums[i] = arr[i] % 100000;

        return nums;

    }
}