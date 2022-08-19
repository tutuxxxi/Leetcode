package com.linmu.q1450;

/**
 * @author by lijun
 * @date 2022/8/19 9:34
 */
public class Q1450 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int index = 0; index < startTime.length; index++) {
            if(startTime[index] <= queryTime && endTime[index] >= queryTime) {
                count++;
            }
            if(startTime[index] > queryTime) {
                break;
            }
        }
        return count;
    }
}
