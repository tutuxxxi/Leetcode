package com.linmu.q743;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/8/2 8:33 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q743 {
    public static void main(String[] args) {
        System.out.println(new Solution().networkDelayTime(new int[][]{
                {1,2,1}
        }, 2, 2));
    }
}

class Solution {
    private Map<Integer, Integer> mark;
    Map<Integer, Map<Integer, Integer>> map;
    public int networkDelayTime(int[][] times, int n, int k) {
        map = new HashMap<>();
        mark = new HashMap<>();
        mark.put(k, 0);

        for(int[] time : times){
            Map<Integer, Integer> tempMap = map.getOrDefault(time[0], new HashMap<>());
            tempMap.put(time[1], time[2]);
            map.put(time[0], tempMap);
        }

        networkDelayTime(k);

        if(mark.size() != n){
            return -1;
        }
        int res = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : mark.entrySet()) {
            res = Math.max(res, entry.getValue());
        }

        return res;
    }

    public void networkDelayTime(int k){
        Map<Integer, Integer> map = this.map.get(k);
        if(map != null){
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer time = mark.getOrDefault(k, 0);

                if(!mark.containsKey(entry.getKey()) || mark.get(entry.getKey()) >  time + entry.getValue()){
                    mark.put(entry.getKey(), time + entry.getValue());
                    networkDelayTime(entry.getKey());
                }
            }
        }
    }
}
