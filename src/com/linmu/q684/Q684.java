package com.linmu.q684;

import java.util.Arrays;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/13 9:42 上午
 * @description：leetcode q684
 * @modified By：
 * @version: 1.0
 */
public class Q684 {
    public static void main(String[] args) {
        new Solution().findRedundantConnection(new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {1,4},
                {1,5}
        });
    }
}


class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        for(int i = edges.length - 1; i >= 0; i--){
            //创建一个并查集, 其中的个数 = 边的条数 = 结点个数
            DisjointSetUnion union = new DisjointSetUnion(edges.length);

            for(int j = 0; j < i; j++){
                union.unionSet(edges[j][0], edges[j][1]);
            }
            //跳过第i个
            for(int j = i + 1; j < edges.length; j++){
                union.unionSet(edges[j][0], edges[j][1]);
            }

            //检查第i个是否联通
            if(union.find(edges[i][1]) == union.find(edges[i][0])){
                return edges[i];
            }
        }

        return new int[0];
    }
}

class DisjointSetUnion {
    int[] f;
    int[] rank;
    int n;

    public DisjointSetUnion(int n) {
        this.n = n + 1;
        rank = new int[this.n];
        Arrays.fill(rank, 1);
        f = new int[this.n];
        for (int i = 0; i < this.n; i++) {
            f[i] = i;
        }
    }
    
    public int find(int x) {
        return f[x] == x ? x : (f[x] = find(f[x]));
    }

    public void unionSet(int x, int y) {
        int fx = find(x), fy = find(y);
        if (fx == fy) {
            return;
        }
        if (rank[fx] < rank[fy]) {
            int temp = fx;
            fx = fy;
            fy = temp;
        }
        //总是将深度低的树合并到深度高的树上
        rank[fx] += rank[fy];
        f[fy] = fx;
    }
}