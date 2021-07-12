package com.linmu.q1744;

import java.util.Arrays;

/**
 * @author ：xxx_
 * @date ：Created in 2021/6/2 9:43 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1744 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        for(int[] query: queries){
            /*
                没有吃到的可能情况:    min < max < candyNum
                                    min > candyNum
             */

            for(int i = 0; i<query[0]; i++){
                query[1] -= candiesCount[i];
            }

//            if(query[1] > )
        }
        return null;
    }
}
