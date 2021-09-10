package com.linmu.q413;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/8/10 8:41 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q413 {
    public static void main(String[] args) {
        new Solution().numberOfArithmeticSlices(new int[]{
                3,-1,-5
        });
    }
}


class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int preIndex = -1, mark = 0;
        int res = 0;

        for(int i = 1; i<nums.length; i++){
            if(preIndex == -1){
                mark = nums[i] - nums[i-1];
                preIndex = i-1;
            }else{
                if(nums[i] - nums[i-1] != mark){
                    int n = i - 1 - preIndex;
                    if(n >= 2){
                        res += n * (n - 1) / 2;
                    }

                    mark = nums[i] - nums[i-1];
                    preIndex = i-1;
                }
            }
        }

        int n = nums.length - 1 - preIndex;
        if(n >= 2){
            res += (n - 1) * n / 2;
        }

        return res;
    }
}
