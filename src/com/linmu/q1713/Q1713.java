package com.linmu.q1713;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/26 11:29 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1713 {
    public static void main(String[] args) {
        new Solution().minOperations(new int[]{
                6,4,8,1,3,2
        }, new int[]{
                4,7,6,2,3,8,6,1
        });
    }
}

class Solution {
    public int minOperations(int[] target, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int num : target){
            set.add(num);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])){
                List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
                list.add(i);
                map.put(arr[i], list);
            }
        }

        int count = 0, index = -1;

        continue_point: for(int num : target){
            if(map.containsKey(num)){
                List<Integer> list = map.get(num);
                for(Integer i : list){
                    if(index < i){
                        index = i;
                        continue continue_point;
                    }
                }
            }
            count++;
        }

        return count;
    }
}
