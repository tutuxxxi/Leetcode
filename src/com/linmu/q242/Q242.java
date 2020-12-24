package com.linmu.q242;

import java.util.Arrays;

public class Q242 {
    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
    }
}



class Solution {
    public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();

        if(cs.length != ts.length)
            return false;

        Arrays.sort(cs);
        Arrays.sort(ts);

        int index = 0;
        while(index < cs.length)
            if(cs[index] != ts[index++])
                return false;
        return true;
    }
}