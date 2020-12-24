package com.linmu.q80;

import java.util.Arrays;

public class Q80 {
    public static void main(String[] args) {
        int[] a = new int[]{
                1,1,1,2,3,3,4,5,5,5,6,6,6,6,7,7,7,7
        };
        new Solution().removeDuplicates(a);
        System.out.println(Arrays.toString(a));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        //记录位移数的数组
//        int[] count = new int[nums.length];
//
//        //起始位置
//        int startIndex = 0;
//        for(int i = 1; i < nums.length; i++){
//            if(nums[i] == nums[startIndex]){
//                //判断距离 超过距离之后步数增大
//                if(i - startIndex > 1)
//                    count[i] = count[i-1] + 1;
//                else
//                    count[i] = count[i-1];
//            }else{
//                startIndex = i;
//                count[i] = count[i-1];
//            }
//
//            nums[i - count[i]] = nums[i];
//        }
//        return nums.length - count[nums.length-1];


//        //累计步数
//        int count = 0;
//
//        //起始位置
//        int startIndex = 2;
//        for(int i = 2; i < nums.length; i++){
//            if(nums[i] == nums[startIndex]){
//                //判断距离 超过距离之后步数增大
//                if(i - startIndex > 1){
//                    count++;
//                }else{
//                    nums[i - count] = nums[i];
//                }
//
//            }else{
//                startIndex = i;
//                nums[i - count] = nums[i];
//            }
//
//        }
//
//        return nums.length - count;

        if(nums.length < 3)
            return nums.length;

        int index = 2;

        for(int i = 2; i<nums.length; ++i){

            //当快指针位置的内容与慢指针不相同时，将快指针的内容复制并移动慢指针（因为复制导致此处成为了有效位置）
            if(nums[i] != nums[index-2])
                nums[index++] = nums[i];
            //如果相同则证明可以进行填入的位置+1， 则快指针移动慢指针不管，两指针之间的差值都是可以填入的位置
        }

        return index;
    }
}


