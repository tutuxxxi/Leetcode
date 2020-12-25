package com.linmu.q455;

import java.util.Arrays;

public class Q455 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int gIndex = 0;
        int sIndex = 0;

        //两个指针没有到达边界时
        while(gIndex != g.length && sIndex != s.length){

            if(g[gIndex] <= s[sIndex]){
                //能够分发时
                count++;
                gIndex++;
            }
            //不能分发， sIndex++;
            sIndex++;
        }
        return count;
    }
}
