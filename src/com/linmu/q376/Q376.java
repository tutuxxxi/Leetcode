package com.linmu.q376;

public class Q376 {
    public static void main(String[] args) {
        new Solution().wiggleMaxLength(new int[]{
                1,3,5,4,1,5,2,8,1
        });

    }
}


class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        }

        byte mark = 0;
        int count = 1;

        for(int i = 1; i<nums.length; i++){

            if(nums[i] > nums[i-1]){
                //当前值大于前一个值时
                if(mark != 1){
                    //只要当前不是升序，就应该添加
                    mark = 1;
                    count++;
                }
            }else if(nums[i] < nums[i-1]){
                //当前值小于前一个值时
                if(mark != -1){
                    //只要当前不是降序，就应该添加
                    mark = -1;
                    count++;
                }
            }

            //两个值相等时，什么都不改变
        }
        return count;
    }
}