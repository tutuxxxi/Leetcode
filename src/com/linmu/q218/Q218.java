package com.linmu.q218;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/13 3:57 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q218 {
    public static void main(String[] args) {
        System.out.println(new Solution().getSkyline(new int[][]{
                {2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}
        }));;
    }
}

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        SortedMap<Integer, List<Integer>> operator = new TreeMap<>();
        for(int[] building : buildings){
            List<Integer> orDefault = operator.getOrDefault(building[0], new ArrayList<>());
            orDefault.add(building[2]);
            operator.put(building[0], orDefault);

            orDefault = operator.getOrDefault(building[1], new ArrayList<>());
            orDefault.add(-building[2]);
            operator.put(building[1], orDefault);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(Integer step : operator.keySet()){
            List<Integer> nums = operator.get(step);
            Integer peek = queue.peek();

            for(int num : nums){
                if(num > 0){
                    queue.add(num);
                }else{
                    queue.remove(-num);
                }
            }

            Integer newPeek = queue.peek();
            if(peek == null || !peek.equals(newPeek)){
                List<Integer> list = new ArrayList<>(2);
                list.add(step);
                list.add(newPeek == null ? 0 : newPeek);
                res.add(list);
            }
        }

        return res;
    }
}
