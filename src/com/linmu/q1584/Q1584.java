package com.linmu.q1584;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/19 8:40 上午
 * @description：leetcode q1584
 * @modified By：
 * @version: 1.0
 */
public class Q1584 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int res=0;
        int[][] gra = new int[1005][1005];
        int[] dis = new int[1005];
        int[] flag = new int[1005];

        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                gra[i][j]=Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
            }
        }
        for(int i=0;i<n;i++){
            int t=-1;
            for(int j=0;j<n;j++){
                if(flag[j] == 0 && (t==-1||dis[t]>dis[j])) {
                    t=j;
                }
            }
            if(i != 0) {
                res+=dis[t];
            }
            flag[t]=1;
            for(int j=0;j<n;j++) {
                if(flag[j] == 0) {
                    dis[j]=Math.min(dis[j],gra[t][j]);
                }
            }
        }
        return res;
    }
}
