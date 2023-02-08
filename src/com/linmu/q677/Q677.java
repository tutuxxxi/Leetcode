package com.linmu.q677;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author by lijun
 * @since 2023/1/31 14:04
 */
public class Q677 {
    public static void main(String[] args) {
        //["MapSum","insert","sum","insert","sum"]
        //[[],["a",3],["ap"],["b",2],["a"]]
        MapSum mapSum = new MapSum();
        mapSum.insert("a", 3);
        mapSum.sum("ap");
    }
}


class MapSum {

    private final MapNode dic;

    public MapSum() {
        dic = new MapNode();
    }

    public void insert(String key, int val) {
        findNode(key, true).val = val;
    }

    public int sum(String prefix) {
        return sum(findNode(prefix, false));
    }

    private MapNode findNode(String str, boolean createIfNotExist) {
        char[] chars = str.toCharArray();
        MapNode operator = dic;
        for (char aChar : chars) {
            int index = aChar - 'a';
            if(operator.nextNode[index] == null) {
                if(!createIfNotExist) {
                    return null;
                }
                operator.nextNode[index] = new MapNode();
            }
            operator = operator.nextNode[index];
        }
        return operator;
    }

    private int sum(MapNode node) {
        if(node == null) {
            return 0;
        }

        int ans = node.val;
        for (MapNode mapNode : node.nextNode) {
            ans += sum(mapNode);
        }
        return ans;
    }

    class MapNode {
        MapNode[] nextNode = new MapNode[26];
        int val;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
