package com.linmu.q802;

import com.linmu.Test.Main;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/8/5 9:07 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q802 {
    public static void main(String[] args) {
        new Solution().eventualSafeNodes(new int[][]{
                {1,2,3,4},{1,2},{3,4},{0,4},{}
        });
    }
}

class Solution {
    private Set<Integer> safePoint = new HashSet<>();
    private Set<Integer> unsafePoint = new HashSet<>();

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<graph.length; i++){
            eventualSafeNodes(graph, i, set);
        }



        List<Integer> objects = Arrays.asList(safePoint.toArray(new Integer[0]));
        Collections.sort(objects);
        return objects;
    }


    /**
     * index是否为安全点
     * @param graph
     * @param index
     * @return
     */
    private boolean eventualSafeNodes(int[][] graph, int index, Set<Integer> points){
        if(safePoint.contains(index)){
            return true;
        }

        if(unsafePoint.contains(index)){
            return false;
        }

        // 已走过，不是安全点
        if(points.contains(index)){
            unsafePoint.add(index);
            return false;
        }

        // 只进不出，安全点
        int[] nextIndex = graph[index];
        if(nextIndex == null || nextIndex.length == 0){
            safePoint.add(index);
            return true;
        }

        // 判断子结点的安全类型
        points.add(index);
        for(int i : nextIndex){
            if(!eventualSafeNodes(graph, i, points)){
                // 这个点不是安全点
                unsafePoint.add(index);
                points.remove(index);
                return false;
            }
        }


        safePoint.add(index);
        points.remove(index);
        return true;
    }
}
