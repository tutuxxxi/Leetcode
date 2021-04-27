package com.linmu.q220;

import java.util.Collection;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/17 6:25 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q220 {
    public static void main(String[] args) {
        new Solution().containsNearbyAlmostDuplicate(new int[]{
                -3,3,-6
        }, 2, 3);
    }
}


class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t < 0){
            return false;
        }

        //一个排序Set
        TreeSet set = new TreeSet<Integer>();


        for(int i = 0; i<nums.length; i++){
            //如果溢出了先将溢出的元素删除
            if(set.size() > k){
                //删除溢出元素
                set.remove(nums[i - k - 1]);
            }

            if(set.contains(nums[i])){
                //当前存在我们想要加入的数字，则差值为0，必定满足
                return true;
            }

            Integer temp = (Integer) set.ceiling(nums[i]);
            if(temp != null){
                if(Math.abs((long) nums[i] - temp) <= t){
                    return true;
                }
            }
            temp = (Integer) set.floor(nums[i]);
            if(temp != null){
                if(Math.abs((long) nums[i] - temp) <= t){
                    return true;
                }
            }


            set.add(nums[i]);
        }
        return false;
    }
}