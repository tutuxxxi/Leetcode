package com.linmu.q130;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/30 9:15 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q130 {
    public static void main(String[] args) {

    }
}

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        int rows = board.length;
        int cols = board[0].length;

        // 用一个虚拟节点, 边界上的O 的父节点都是这个虚拟节点
        UnionFind uf = new UnionFind(rows * cols + 1);
        int dummyNode = rows * cols;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    // 遇到O进行并查集操作合并
                    if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                        // 边界上的O,把它和dummyNode 合并成一个连通区域.
                        uf.union(i * cols + j, dummyNode);
                    } else {
                        // 和上下左右合并成一个连通区域.
                        if (i > 0 && board[i - 1][j] == 'O')
                            uf.union(i * cols + j, (i - 1) * cols + j);
                        if (i < rows - 1 && board[i + 1][j] == 'O')
                            uf.union(i * cols + j, (i + 1) * cols + j);
                        if (j > 0 && board[i][j - 1] == 'O')
                            uf.union(i * cols + j, i * cols + j - 1);
                        if (j < cols - 1 && board[i][j + 1] == 'O')
                            uf.union(i * cols + j, i * cols + j + 1);
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (uf.isConnected(i * cols + j, dummyNode)) {
                    // 和dummyNode 在一个连通区域的,那么就是O；
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
}


class UnionFind {
    int[] parents;

    public UnionFind(int totalNodes) {
        parents = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            parents[i] = i;
        }
    }


    void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2) {
            parents[root2] = root1;
        }
    }

    /**
     * 获取父结点并压缩
     * @param node
     * @return
     */
    int find(int node) {
        while (parents[node] != node) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }
        return node;
    }

    boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }
}
