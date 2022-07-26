package com.linmu.q75;

import java.util.Arrays;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/14 11:44 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q75 {
    public static void main(String[] args) {
        int[] res = new int[]{2,0,2,1,1,0};
        new Solution().sortColors(res);
        System.out.println(Arrays.toString(res));
    }
}

class Solution {
    public void sortColors(int[] nums) {
        if(nums.length != 1) {
            int preIndex = 0, lastIndex = nums.length-1;

            point:
            while(true) {

                while(preIndex < nums.length && nums[preIndex] == 0) {
                    preIndex++;
                }

                if(preIndex == nums.length) {
                    return;
                }

                while(lastIndex >= 0 && nums[lastIndex] == 2) {
                    lastIndex--;
                }

                if(lastIndex == -1) {
                    return;
                }

                for(int i = preIndex; i <= lastIndex; i++) {
                    if(nums[i] == 0) {
                        int temp = nums[preIndex];
                        nums[preIndex] = nums[i];
                        nums[i] = temp;
                        continue point;
                    }else if(nums[i] == 2) {
                        int temp = nums[lastIndex];
                        nums[lastIndex] = nums[i];
                        nums[i] = temp;
                        continue point;
                    }
                }
                break;
            }
        }
    }
}
