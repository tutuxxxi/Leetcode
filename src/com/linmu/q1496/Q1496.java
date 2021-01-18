package com.linmu.q1496;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/14 8:48 上午
 * @description：leetcode q1496
 * @modified By：
 * @version: 1.0
 */
public class Q1496 {
    public static void main(String[] args) {
        new Solution().isPathCrossing("NESWW");
    }
}

class Solution {
    public boolean isPathCrossing(String path) {
        char x = 0, y = 0;
        char[] chars = path.toCharArray();
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for(char c : chars){
            switch (c){
                case 'n':
                case 'N':
                    x++;
                    break;
                case 's':
                case 'S':
                    x--;
                    break;
                case 'w':
                case 'W':
                    y--;
                    break;
                case 'e':
                case 'E':
                    y++;
                    break;
            }
            int num = x * 20001 + y;
            if(set.contains(num)){
                return true;
            }else{
                set.add(num);
            }
        }
        return false;
    }
}
