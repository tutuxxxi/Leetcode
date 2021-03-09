package com.linmu.q303;

import java.util.Arrays;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/1 09:11
 * @description：
 * @modified By：
 * @version:
 */
public class Q303 {
    public static void main(String[] args) {

    }
}


class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        return Arrays.stream(Arrays.copyOfRange(nums, i, j+1)).sum();
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */