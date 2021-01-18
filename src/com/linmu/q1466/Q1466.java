package com.linmu.q1466;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/15 4:04 下午
 * @description：leetcode q1466
 * @modified By：
 * @version: 1.0
 */
public class Q1466 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minReorder(int n, int[][] connections) {
        if(connections.length == 0){
            return 0;
        }
        //纪录所有拥点
        Map<Integer, List<Integer>> in = new HashMap<>();
        Map<Integer, List<Integer>> out = new HashMap<>();
        for (int[] connection : connections){
            if(out.containsKey(connection[0])){
                out.get(connection[0]).add(connection[1]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(connection[1]);
                out.put(connection[0], list);
            }

            if(in.containsKey(connection[1])){
                in.get(connection[1]).add(connection[0]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(connection[0]);
                in.put(connection[1], list);
            }
        }

        //纪录能直接访问到的结点个数
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] mark = new boolean[n];
        mark[0] = true;


        queue.offer(0);
        int length = 0;

        while((length = queue.size()) != 0){
            int index = queue.poll();

            //当前结点拥有出度
            if(out.containsKey(index)){
                for(int index1 : out.get(index)){
                    if(!mark[index1]){
                        //当前能够直接访问下一个未访问结点
                        count++;
                        mark[index1] = true;
                        queue.offer(index1);
                    }
                }
            }

            if(in.containsKey(index)){
                for(int index1 : in.get(index)){
                    if(!mark[index1]){
                        //入度结点未被访问过
                        mark[index1] = true;
                        queue.offer(index1);
                    }
                }
            }
        }

        return count;
    }
}
