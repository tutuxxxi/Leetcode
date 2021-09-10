package com.linmu.q33;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/20 4:21 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q33 {
    public static void main(String[] args) {

    }
}
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            // 右边有序
            if(nums[mid] < nums[right]){
                // 目标值在右边
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                // 目标值在左边
                }else{
                    right = mid - 1;
                }
            // 左边有序
            }else{
                // 目标值在左边
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                // 目标值在右边
                }else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
