package com.linmu.q547;

import java.util.Arrays;

public class Q547 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int num = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                num++;
                dfs(i, isConnected, visited);
            }
        }
        return num;
    }

    private void dfs(int i, int[][] isConnected, boolean[] visited) {
        visited[i] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(j, isConnected, visited);
            }
        }
    }
}
