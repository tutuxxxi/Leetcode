package com.linmu.q493;

import java.util.Arrays;

public class Q493 {
    public static void main(String[] args) {
        int[] a = new int[]{
                -10,-9,-8,-7
        };
//        new Solution().mergeSort(a, 0, a.length-1);
        System.out.println(new Solution().reversePairs(a));
    }
}


class Solution {
    private int count = 0;

    public int reversePairs(int[] nums) {
        if(nums.length > 1)
            mergeSort(nums, 0, nums.length - 1);
        return count;
    }


    public void mergeSort(int[] nums, int start, int end){
        int center = start + (end - start) / 2;

        if((end - start + 1) > 2){
            mergeSort(nums, start, center);
            mergeSort(nums, center + 1, end);
        }

        int leftIndex = start;
        int rightIndex = center + 1;
        int tempIndex = 0;
        int[] temp = new int[end - start + 1];

        while(leftIndex <= center && rightIndex <= end){
            if(nums[leftIndex] >= nums[rightIndex]){
                temp[tempIndex++] = nums[rightIndex];

                //可能发生count变化
                if((long)nums[leftIndex] > ((long)2 * nums[rightIndex])){
                    //满足条件则左边的全都满足条件
                    count += (center - leftIndex + 1);
                }else{
                    //就算不满足，后面也可能有满足的，遍历寻找一次

                    int temp2 = leftIndex + 1;
                    while(temp2 <= center){
                        if((long)nums[temp2] > ((long)2 * nums[rightIndex])){
                            //遍历找到第一个即可，添加后跳出遍历
                            count += (center - temp2 + 1);
                            break;
                        }
                        temp2++;
                    }
                }

                rightIndex++;
            }else{
                temp[tempIndex++] = nums[leftIndex];

                if(nums[leftIndex] < 0 && nums[rightIndex] < 0) {
                    //两个都为负数的时候，可能发生小于乘以2依旧大于

                    int temp2 = rightIndex;

                    while((long)nums[leftIndex] > ((long)2 * nums[temp2]) && temp2 <= end){
                        count++;
                        temp2++;
                    }
                }

                leftIndex++;
            }
        }

        while(leftIndex <= center)
            temp[tempIndex++] = nums[leftIndex++];
        while(rightIndex <= end)
            temp[tempIndex++] = nums[rightIndex++];

        for(tempIndex = 0; start <= end; start++){
            nums[start] = temp[tempIndex++];
        }
    }

}