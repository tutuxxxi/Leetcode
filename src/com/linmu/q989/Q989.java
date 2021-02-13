package com.linmu.q989;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/22 13:46
 * @description：leetcode q989
 * @modified By：
 * @version: 1.0
 */
public class Q989 {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int len = A.length;
        int lastNum =K;
        LinkedList<Integer> ret= new LinkedList<>();

        int i = len-1;
        while(i >=0 || lastNum > 0){
            if(i >= 0){
                lastNum+=A[i];
            }
            ret.addFirst(lastNum%10);
            lastNum/=10;
            i--;
        }

        return ret;
    }
}
