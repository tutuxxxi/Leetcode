package com.linmu.q947;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/15 9:12 上午
 * @description：leetcode q947
 * @modified By：
 * @version: 1.0
 */
public class Q947 {
    public static void main(String[] args) {
        new Solution().removeStones(new int[][]{
                {0,0},
                {0,1},
                {1,0},
                {1,2},
                {2,1},
                {2,2}
        });
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        Union union = new Union();

        /*
            只需要知道是否联通，并不要求完全知道各个联通域中各自有多少个元素
         */

        for(int[] stone : stones){
            union.union(stone[0] + 10001, stone[1]);
        }
        Set<Integer> set = new HashSet<>();
        for(int[] stone: stones){
            int temp = union.find(stone[0] + 10001);
            if(!set.contains(temp)){
                set.add(temp);
            }
        }

        return stones.length - set.size();
    }
}


class Union{

    Map<Integer,Integer> list;
    Map<Integer,Integer> rank;

    public Union(){
         list = new HashMap<>();
         rank = new HashMap<>();
    }

    public int find(int index){
        if(!list.containsKey(index)){
            list.put(index, index);
            rank.put(index, 1);
            return index;
        }

        int temp = list.get(index);
        if(temp != index){
            list.put(index, find(temp));
        }

        return list.get(index);
    }

    public void union(int index1, int index2){
        int pre1 = find(index1);
        int pre2 = find(index2);

        if(pre1 != pre2){
            if(rank.get(pre2) > rank.get(pre1)){
                int temp = pre1;
                pre1 = pre2;
                pre2 = temp;
            }

            rank.put(pre1, rank.get(pre1) + rank.get(pre2));
            list.put(pre2, pre1);
        }
    }
}
