package com.linmu.q4;

import java.util.Arrays;

public class Q4 {
    public static void main(String[] args) {
        int[] a = new int[]{
                1,2,3,4,5,6,7,10,11,12,13,14,15,16,17,18,19,20
        };

        int[] b = new int[]{
                8,9
        };

        System.out.println(new Solution().findMedianSortedArrays(a, b));
    }
}


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length == 0 && nums2.length == 0)
            return 0;

        int length = (nums1.length + nums2.length)/2;
        //标记当前中位数为一个还是两个 true为俩 false为1
        boolean mark = (nums1.length + nums2.length) % 2 == 0;


        if(nums1.length == 0){
            if(mark){
                return (nums2[length-1] + nums2[length]) / 2.0;
            }

            return nums2[length];
        }

        if(nums2.length == 0){
            if(mark){
                return (nums1[length-1] + nums1[length]) / 2.0;
            }

            return nums1[length];
        }

        //记录中位数
        double num1 = 0, num2 = 0;

        //指针
        int num1Pointer = 0;
        int num2Pointer = 0;

        for(int i = 0; i<length+1; i++){
            //谁小就存储谁
            if(num1Pointer == -1){
                num2 = num1;
                num1 = nums2[num2Pointer++];
                continue;
            }

            if(num2Pointer == -1){
                num2 = num1;
                num1 = nums1[num1Pointer++];
                continue;
            }


            if(nums1[num1Pointer] < nums2[num2Pointer]){
                num2 = num1;
                num1 = nums1[num1Pointer];
                if (num1Pointer == nums1.length - 1)
                    num1Pointer = -1;
                else
                    num1Pointer++;
            }else{
                num2 = num1;
                num1 = nums2[num2Pointer];
                if (num2Pointer == nums2.length - 1)
                    num2Pointer = -1;
                else
                    num2Pointer++;
            }
        }

        //如果中位数为双数
        if(mark){
            num1 += num2 ;
            num1 /= 2;
        }

        return num1;
    }
}