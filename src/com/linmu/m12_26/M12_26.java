package com.linmu.m12_26;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author by lijun
 * @since 2022/12/1 15:13
 */
public class M12_26 {
    public static void main(String[] args) {

    }
}

class Solution {

    private static final Set<Character> all = new HashSet<>(Arrays.asList('+', '-', '*', '/'));

    private static final Set<Character> set1 = new HashSet<>(Arrays.asList('*', '/'));

    private static final Set<Character> set2 = new HashSet<>(Arrays.asList('+', '-'));

    public int calculate(String s) {
        // 1+2*3/6-1

        s = s.replace(" ", "");
        if(all.contains(s.charAt(0))) {
            s = "0" + s;
        }

        int preIndex = 0, nextIndex = 0;
        // 先遍历找 * /




        return 0;
    }
}
