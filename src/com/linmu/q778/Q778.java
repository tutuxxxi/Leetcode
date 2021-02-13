package com.linmu.q778;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/30 17:04
 * @description：leetcode q778
 * @modified By：
 * @version: 1.0
 */
public class Q778 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        //Kruskal构造连边
        List<int[]> edges = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int id = i*n+j;
                if(i<n-1){
                    edges.add(new int[]{id,id+n,Math.max(grid[i][j],grid[i+1][j])});
                }
                if(j<n-1){
                    edges.add(new int[]{id,id+1,Math.max(grid[i][j],grid[i][j+1])});
                }
            }
        }
        //根据结点之间的权值进行排序
        Collections.sort(edges,new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2){
                return o1[2] - o2[2];
            }
        });
        int ans = 0;
        //从小到大连通结点
        UnionFind uf = new UnionFind(n*n);
        for(int i=0;i<edges.size();i++){
            int[] temp = edges.get(i);
            int x = temp[0];
            int y = temp[1];
            int dp = temp[2];
            if(uf.find(x)!=uf.find(y)){
                uf.union(x,y);
                ans = dp;
            }
            //左上角结点和右下角结点连通
            if(uf.find(0)==uf.find(n*n-1)){
                break;
            }
        }
        return ans;
    }
}
//并查集
class UnionFind{
    int[] f;
    public UnionFind(int n){
        f = new int[n];
        for(int i=0;i<n;i++){
            f[i] = i;
        }
    }
    //查
    public int find(int x){
        if(f[x]!=x){
            f[x] = find(f[x]);
        }
        return f[x];
    }
    //并
    public void union(int x,int y){
        if(find(x)!=find(y)){
            f[find(x)] = find(y);
        }
    }
}