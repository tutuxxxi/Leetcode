package com.linmu.q448;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/13 14:03
 * @description：leetcode q448
 * @modified By：
 * @version: 1.0
 */
public class Q448 {
    public static void main(String[] args) {
    }
}

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<>();

        for(int i = 0; i<nums.length; i++){
            //对每一个遍历

            //取出当前值的绝对值
            int num = Math.abs(nums[i]) - 1;

            //将num位置的数值变为负数
            nums[num] = nums[num] > 0 ? -nums[num] : nums[num];
        }

        for(int i = 0; i<nums.length; i++){
            if(nums[i] > 0){
                //当前位置的数值不存在
                res.add(i + 1);
            }
        }

        return res;
    }
}
