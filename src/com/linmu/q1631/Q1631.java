package com.linmu.q1631;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/29 18:23
 * @description：leetcode q1631
 * @modified By：
 * @version: 1.0
 */
public class Q1631 {
    public static void main(String[] args) {

    }
}

//class Solution {
//    public int minimumEffortPath(int[][] heights) {
//        Union union = new Union(heights.length * 1000 + heights[0].length);
//        
//    }
//}


class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        //Kruskal构造连边
        List<int[]> edges = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //遍历每个节点，对每个节点进行一个值转化
                int id = i*cols+j;
                if(i<rows-1){
                    edges.add(new int[]{id,id+cols,Math.abs(heights[i][j]-heights[i+1][j])});
                }
                if(j<cols-1){
                    edges.add(new int[]{id,id+1,Math.abs(heights[i][j]-heights[i][j+1])});
                }
            }
        }
        //根据结点之间的权值进行排序
        Collections.sort(edges, (o1, o2) -> o1[2] - o2[2]);

        int ans = 0;
        //从小到大连通结点
        Union union = new Union(rows*cols);
        for(int i=0;i<edges.size();i++){
            int[] temp = edges.get(i);
            int x = temp[0];
            int y = temp[1];
            int dp = temp[2];
            if(!union.check(x, y)){
                union.union(x,y);
                ans = dp;
            }
            //左上角结点和右下角结点连通
            if(union.check(0, rows*cols-1)){
                break;
            }
        }
        return ans;
    }
}

class Union{
    private int[] f;
    private int[] stack;

    public Union(int length){
        f = new int[length + 1];
        stack = new int[length + 1];

        Arrays.fill(stack, 1);

        for(int i = 1; i < length + 1; i++){
            f[i] = i;
        }
    }

    public int find(int index){
        return f[index] == index ? index : (f[index] = find(f[index]));
    }

    public boolean check(int index1, int index2){
        return find(index1) == find(index2);
    }

    public void union(int index1, int index2){
        if(!check(index1, index2)){
            //两个不同时
            int preIndex1 = find(index1);
            int preIndex2 = find(index2);

            if(stack[preIndex2] > stack[preIndex1]){
                int temp = preIndex1;
                preIndex1 = preIndex2;
                preIndex2 = temp;
            }

            stack[preIndex1] += stack[preIndex2];
            f[preIndex2] = preIndex1;
        }
    }
}
