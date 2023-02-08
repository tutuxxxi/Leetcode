package com.linmu.q1233;

import java.util.*;

/**
 * @author by lijun
 * @since 2023/2/8 8:59
 */
public class Q1233 {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Node root = new Node();

        for (String s : folder) {
            String[] nodes = s.substring(1).split("/");

            Node operator = root;
            int index = 0;
            while(index < nodes.length && operator.nextDir.containsKey(nodes[index])) {
                operator = operator.nextDir.get(nodes[index]);
                index++;
            }

            // 如果获取到完整的位置了，自己为之前文件夹的父文件夹，则清除之前的文件夹
            if(index == nodes.length) {
                operator.nextDir.clear();
            } else if(index == 0) {
                // 构建
                for (String node : nodes) {
                    Node nextNode = new Node();
                    operator.nextDir.put(node, nextNode);
                    operator = nextNode;
                }
            } else {
                // 如果位置已经存在了，则判断这个文件夹是否是其他文件夹的附属品，如果是则可以继续构建
                if(!operator.nextDir.isEmpty()) {
                    while(index < nodes.length) {
                        Node nextNode = new Node();
                        operator.nextDir.put(nodes[index++], nextNode);
                        operator = nextNode;
                    }
                }
            }
        }

        // 字典树中只存放了答案 DFS
        List<String> ans = new LinkedList<>();
        dfs(root, "", ans);
        return ans;
    }

    private static void dfs(Node root, String prefix,List<String> ans) {
        if(root == null) {
            return;
        }
        if(root.nextDir.isEmpty()) {
            ans.add(prefix);
            return;
        }
        root.nextDir.forEach((k, v) -> {
            dfs(v, prefix + "/" + k, ans);
        });
    }

    private static class Node {
        Map<String, Node> nextDir = new HashMap<>(16) ;
    }
}
