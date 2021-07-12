package com.linmu.q852;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/6/15 8:27 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q852 {
    public static void main(String[] args) {
    }
}

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        for(int i = 0;i < arr.length - 1; i ++) {
            if(arr[i] > arr[i+1] ) {
                return i;
            }
        }
        return 0;
    }
}
