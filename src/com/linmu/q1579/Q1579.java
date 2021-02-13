package com.linmu.q1579;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/27 11:39
 * @description：leetcode q1579
 * @modified By：
 * @version: 1.0
 */
public class Q1579 {
    public static void main(String[] args) {

    }
}
class Solution {
    int[] p1 = new int[100009];
    int[] p2 = new int[100009];
    void union(int[] p, int a, int b) {
        p[find(p, a)] = p[find(p, b)];
    }
    int find(int[] p, int x) {
        if (p[x] != x) p[x] = find(p, p[x]);
        return p[x];
    }
    boolean query(int[] p, int a, int b) {
        return find(p, a) == find(p, b);
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        for (int i = 1; i <= n; i++) {
            p1[i] = i;
            p2[i] = i;
        }
        Arrays.sort(edges, (a,b)->b[0]-a[0]);

        int ans = 0;
        Set<int[]> s1 = new HashSet<>(), s2 = new HashSet<>();
        for (int[] edge : edges) {
            int type = edge[0], a = edge[1], b = edge[2];
            if (type == 1) {
                if (!query(p1, a, b)) {
                    union(p1, a, b);
                } else {
                    ans++;
                }
            } else if (type == 2) {
                if (!query(p2, a, b)) {
                    union(p2, a, b);
                } else {
                    ans++;
                }
            } else {
                if (!query(p1, a, b)) {
                    union(p1, a, b);
                } else {
                    s1.add(edge);
                }
                if (!query(p2, a, b)) {
                    union(p2, a, b);
                } else {
                    s2.add(edge);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!query(p1, 1, i)) return -1;
            if (!query(p2, 1, i)) return -1;
        }
        Set<int[]> set = new HashSet<>();
        set.addAll(s1);
        set.retainAll(s2);
        ans += set.size();
        return ans;
    }
}