package com.linmu.o53;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/16 8:36 上午
 * @description：
 * @modified By：
 * @version:
 */
public class O53 {
    public static void main(String[] args) {
        new Solution().search(new int[]{
                5,7,7,8,8,10
        }, 8);
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int pre = 0, last = nums.length-1;
        int count = 0;

        while(pre < last){
            int mid = (pre + last) / 2;
            if(nums[mid] > target){
                pre = mid + 1;
            }else if(nums[mid] < target){
                last = mid - 1;
            }else{
        // 找到了
        System.out.println();
            }
        }

        return count;
    }
}
