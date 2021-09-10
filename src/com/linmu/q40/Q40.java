package com.linmu.q40;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/6 3:24 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q40 {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 30));
    }
}

class Solution {
    List<List<Integer>> res;
    LinkedList<Integer> operator;
    List<Integer> step;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        operator = new LinkedList<>();
        step = new ArrayList<>();
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
                return;
            }else if(temp < target){
                operator.addLast(candidates[i]);
                combinationSum(candidates, target, temp, i + 1);
                Integer integer = operator.removeLast();
                while(i < candidates.length && candidates[i] == integer) {
                    i++;
                }
                i--;
            }else{
                return;
            }
        }
    }

}
