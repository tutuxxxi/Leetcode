package com.linmu.q1833;

import java.util.Arrays;

/**
 * @author by lijun
 * @date 2022/8/23 14:12
 */
public class Q1833 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int num = 0;
        Arrays.sort(costs);
        for (int cost : costs) {
            if((coins -= cost) >= 0) {
                num++;
                continue;
            }
            break;
        }
        return num;
    }
}
