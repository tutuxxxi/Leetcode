package com.linmu.q239;

public class Q239 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0 || nums.length == 0){
            return new int[0];
        }
        int maxIndex = -1;
        int[] res = new int[nums.length - k + 1];

        for(int i = k - 1; i<nums.length; i++){
            if(i - maxIndex >= k){
                //此时最大值已经在区间外了，需要重新寻找最大值
                maxIndex = i - k + 1;
                for(int j = maxIndex + 1; j <= i; j++){
                    if(nums[maxIndex] <= nums[j]){
                        maxIndex = j;
                    }
                }
            }else{
                //此时只需要比较新加入的值是不是比最大值大即可
                if(nums[i] >= nums[maxIndex]){
                    maxIndex = i;
                }
            }
            res[i - k + 1] = nums[maxIndex];
        }
        return res;
    }
}