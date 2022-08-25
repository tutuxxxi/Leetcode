package com.linmu.q1129;

import java.util.*;

/**
 * @author by lijun
 * @date 2022/8/23 13:36
 */
public class Q1129 {
    public static void main(String[] args) {
        // 5
        //[[0,1],[1,2],[2,3],[3,4]]
        //[[1,2],[2,3],[3,1]]

        int[] ints = new Solution().shortestAlternatingPaths(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, new int[][]{{1, 2}, {2, 3}, {3, 1}});
        System.out.println(Arrays.toString(ints));
    }
}

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, Set<Integer>> redMap = initMap(redEdges);
        Map<Integer, Set<Integer>> blueMap = initMap(blueEdges);

        // 红蓝交替BFS
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        bfs(redMap, blueMap, ans);
        bfs(blueMap, redMap, ans);
        return ans;
    }

    /**
     * 交替BFS
     *
     * @param firstMap
     * @param secondMap
     * @param arr
     */
    private void bfs(Map<Integer, Set<Integer>> firstMap, Map<Integer, Set<Integer>> secondMap, int[] arr) {
        Deque<Integer> deque = new LinkedList<>();
        Set<Integer> firstSet = new HashSet<>(), secondSet = new HashSet<>();

        deque.offerFirst(0);
        int size, step = 0;
        while((size = deque.size()) != 0) {
            for (int i = 0; i < size; i++) {
                Integer integer = deque.pollFirst();
                firstSet.add(integer);
                arr[integer] = arr[integer] == -1 ? step : Math.min(step, arr[integer]);

                Set<Integer> integers = firstMap.get(integer);
                if(integers != null && !integers.isEmpty()) {
                    for (Integer num : integers) {
                        if(!secondSet.contains(num)) {
                            deque.offerLast(num);
                        }
                    }
                }
            }

            Map<Integer, Set<Integer>> tempMap = secondMap;
            secondMap = firstMap;
            firstMap = tempMap;

            Set<Integer> tempSet = secondSet;
            secondSet = firstSet;
            firstSet = tempSet;

            step++;
        }
    }


    private Map<Integer, Set<Integer>> initMap(int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>(16);
        for (int[] edge : edges) {
            Set<Integer> integers = map.computeIfAbsent(edge[0], k -> new HashSet<>());
            integers.add(edge[1]);
        }
        return map;
    }
}
