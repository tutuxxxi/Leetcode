package com.linmu.q47;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/9 11:39 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q47 {
    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{3,3,0,3}));
    }
}

class Solution {
    LinkedHashSet<Integer> set = new LinkedHashSet<>();
    LinkedList<Integer> list = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean mark = true;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(mark) {
            mark = false;
            Arrays.sort(nums);
        }
        int preIndex = -1;
        for(int i = 0; i<nums.length; i++) {
            if(!set.contains(i)) {
                if(preIndex == -1 || nums[i] != nums[preIndex]) {
                    set.add(i);
                    list.addLast(nums[i]);
                    if(list.size() == nums.length) {
                        res.add(new ArrayList<>(list));
                    }else{
                        permuteUnique(nums);
                    }
                    list.removeLast();
                    set.remove(i);
                    preIndex = i;
                }
            }
        }
        return res;
    }
}

