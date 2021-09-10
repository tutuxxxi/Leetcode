package com.linmu.q881;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xxx_
 * @date ：Created in 2021/8/26 4:51 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q881 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int light = 0, heavy = people.length - 1;
        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                ++light;
            }
            --heavy;
            ++res;
        }
        return res;
    }
}
