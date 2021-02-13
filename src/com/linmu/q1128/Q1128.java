package com.linmu.q1128;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/26 09:47
 * @description：leetcode q1128
 * @modified By：
 * @version: 1.0
 */
public class Q1128 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for(int[] arr : dominoes){
            int num;
            if(arr[0] < arr[1]){
                num = arr[1] * 10 + arr[0];
            }else{
                num = arr[0] * 10 + arr[1];
            }

            int temp = 0;
            if(map.containsKey(num)){
                temp = map.get(num);
            }
            res += temp;
            map.put(num, temp +1 );
        }

        return  res;
    }
}