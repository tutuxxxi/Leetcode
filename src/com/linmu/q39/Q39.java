package com.linmu.q39;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/8/5 3:59 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q39 {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{1}, 2));
    }
}


class Solution {
    List<List<Integer>> res;

    LinkedList<Integer> operator;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        operator = new LinkedList<>();
        combinationSum(candidates, target, 0, 0);
        return res;
    }

    public void combinationSum(int[] candidates, int target, int sum, int index) {
        for(int i = index; i < candidates.length && sum <= target; i++) {
            int temp = sum + candidates[i];
            if(temp == target) {
                operator.addLast(candidates[i]);
                res.add(new ArrayList<>(operator));
                operator.removeLast();
            }else if(temp < target){
                operator.addLast(candidates[i]);
                combinationSum(candidates, target, temp, i);
                operator.removeLast();
            }else{
                return;
            }
        }
    }

}
