package com.linmu.q46;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/9 11:28 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q46 {
    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[] {
                -3,-2,-1,1,2,3
        }));
    }
}

class Solution {
    LinkedHashSet<Integer> set = new LinkedHashSet<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        for(int num : nums) {
            if(!set.contains(num)) {
                set.add(num);
                if(set.size() == nums.length) {
                    res.add(new ArrayList<>(set));
                }else{
                    permute(nums);
                }
                set.remove(num);
            }
        }
        return res;
    }
}
