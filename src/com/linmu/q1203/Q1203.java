package com.linmu.q1203;

import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/12 3:31 下午
 * @description：leetcode-q1203
 * @modified By：
 * @version: 1.0$
 */
public class Q1203 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>(8);
        List<Integer> list = null;
        lists.add(new ArrayList<>(0));
        list = new ArrayList<>(1);
        list.add(6);
        lists.add(list);
        list = new ArrayList<>(1);
        list.add(5);
        lists.add(list);
        list = new ArrayList<>(1);
        list.add(6);
        lists.add(list);
        list = new ArrayList<>(1);
        list.add(3);
        list.add(6);
        lists.add(list);
        lists.add(new ArrayList<>());
        lists.add(new ArrayList<>());
        lists.add(new ArrayList<>());

        System.out.println(Arrays.toString(new Solution().sortItems(8, 2, new int[]{
                -1,-1,1,0,0,1,0,-1
        }, lists)));;
    }
}

class Solution {
    /**
     * @param n           n个项目
     * @param m           m个小组
     * @param group       group[i]表示小组 group[i] 负责第i个项目
     * @param beforeItems beforeItems[i] 表示项目i的前置项目
     * @return
     */
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        //小组关系图
        Map<Integer, ArrayList<Integer>> groupMap = new HashMap<>();
        //项目关系图
        Map<Integer, ArrayList<Integer>> itemMap = new HashMap<>();


        int[] inDegreeItem = new int[n];
        int k = m;
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = k ++;
            }
        }

        int[] inDegreeGroup = new int[k];

        for (int i = 0; i < group.length; i++) {
            //项目i的前置项目
            List<Integer> beforeItemi = beforeItems.get(i);
            for (Integer j : beforeItemi) {
                //查找前置项目的组号
                if (group[j] != group[i]) {
                    ArrayList<Integer> list = groupMap.getOrDefault(group[j], new ArrayList<>());
                    list.add(group[i]);
                    groupMap.put(group[j], list);
                    //group[i]的入度加一
                    inDegreeGroup[group[i]]++;
                }

                //构建项目的先后顺序图
                ArrayList<Integer> itemList = itemMap.getOrDefault(j, new ArrayList<>());
                itemList.add(i);
                itemMap.put(j, itemList);
                inDegreeItem[i]++;
            }

        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.add(i);
        }
        //得到的是一个组的排序
        List<Integer> integers = topuSort(inDegreeGroup, groupMap, set);
        if (integers.size() == 0) {
            return new int[0];
        }

        List<Integer> res = new ArrayList<>();
        Map<Integer, Set<Integer>> groupIdToItems = new HashMap<>();
        for (int i = 0; i < group.length; i++) {
            Set<Integer> set1 = groupIdToItems.getOrDefault(group[i],new HashSet<>());
            set1.add(i);
            groupIdToItems.put(group[i],set1);
        }

        for (Integer groupId: integers){
            Set<Integer> itms = groupIdToItems.get(groupId);
            if(itms != null){
                List<Integer> li = topuSort(inDegreeItem, itemMap, itms);
                if(li.size()==0 && groupId != m){
                    return new int[0];
                }
                res.addAll(li);
            }

        }

        int[] ans = new int[res.size()];
        int index = 0;
        for(Integer item : res){
            ans[index ++] = item;
        }
        return ans;
    }

    /**
     * @param deg   对应点的入度
     * @param graph 对应的图
     * @param items 需要topu排序的节点
     * @return
     */
    List<Integer> topuSort(int[] deg, Map<Integer, ArrayList<Integer>> graph, Set<Integer> items) {
        int n = items.size();
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int item : items) {
            if (deg[item] == 0) {
                queue.offer(item);
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            ArrayList<Integer> integers = graph.get(u);
            if( items.contains(u) && integers != null && integers.size() != 0){
                for (int v : graph.get(u)) {
                    deg[v]--;
                    if (deg[v] == 0) {
                        queue.offer(v);
                    }
                }
            }
            if (items.contains(u)) {
                items.remove(u);
                res.add(u);
            }

        }
        return res.size() == n ? res : new ArrayList<>();
    }
}



