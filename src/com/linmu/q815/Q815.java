package com.linmu.q815;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/6/28 5:13 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q815 {
    public static void main(String[] args) {
        System.out.println(new Solution().numBusesToDestination(new int[][]{
                {1,2,7}, {3,6,7}
        }, 1, 6));
    }
}

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }

        // 记录站台可以搭乘的车次
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i<routes.length; i++){
            for(int j = 0; j<routes[i].length; j++){
                List<Integer> list = new ArrayList<>();
                if(map.containsKey(routes[i][j])){
                    list = map.get(routes[i][j]);
                }
                list.add(i);
                map.put(routes[i][j], list);
            }
        }

        // 记录set，保证车站不会被重复使用
        Set<Integer> set = new HashSet<>();
        for(Integer i : map.keySet()){
            set.add(i);
        }
        // 记录车次，保证车次不会被重复使用
        boolean[] set2 = new boolean[routes.length];

        List<Integer> list = new ArrayList<>();
        list.add(source);
        int count = 0;

        while(true) {
            List<Integer> newList = new ArrayList<>();
            count++;

            // i为当前能够到达的车站index
            for(Integer i : list){
                if(set.contains(i)){
                    set.remove(i);

                    // list1中为该车站能够搭乘的车次号码
                    List<Integer> list1 = map.get(i);
                    for(Integer i1 : list1){
                        if(!set2[i1]){
                            set2[i1] = true;

                            // 获取车次号码能够到达的车站，进行循环
                            for(int i2 : routes[i1]){
                                if(set.contains(i2)){
                                    newList.add(i2);

                                    if(i2 == target){
                                        return count;
                                    }
                                }
                            }


                        }
                    }
                }
            }

            if(newList.isEmpty()){
                return -1;
            }else{
                list = newList;
            }
        }
    }
}
