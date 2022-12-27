package com.linmu.q755;

import javax.print.attribute.standard.OrientationRequested;

/**
 * @author by lijun
 * @since 2022/11/16 8:40
 */
public class Q755 {
    public static void main(String[] args) {
        System.out.println(new Solution().isIdealPermutation(new int[]{2,0,1}));
    }
}

class Solution {
    public boolean isIdealPermutation(int[] nums) {
        // 除了局部倒置之外不存在任何倒置
        // 即 任意一个数字， 只能大于其后的第一个数字，否则为false

        int length = nums.length;

        // 维护最小值
        int minValue, preMinValue;
        minValue = preMinValue = nums[length - 1];

        for(int i = length - 2; i >= 0; i--) {
            int value = nums[i];
            int preValue = nums[i + 1];

            // 当前值小于minValue时，minValue必须为前一个数字
            if(value > preMinValue && preMinValue != minValue) {
                return false;
            }
            if(value > minValue && minValue != preValue) {
                return false;
            }

            if(value < minValue) {
                preMinValue = minValue;
                minValue = value;
            }
            if(value > minValue && value < preMinValue) {
                preMinValue = minValue;
            }
        }
        return true;
    }
}
