package com.linmu.q78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/15 1:55 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q78 {
    public static void main(String[] args) {

    }
}


class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        for(int i = 0; i<=nums.length; i++) {
            subsets(0, i);
        }
        return res;
    }

    /**
     * 从from开始还要取k个数的集合
     * @param from
     * @param k
     */
    private void subsets(int from, int k) {
        if(k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(; from < nums.length; from++) {
            list.addLast(nums[from]);
            subsets(from+1, k-1);
            list.removeLast();
        }
    }
}
