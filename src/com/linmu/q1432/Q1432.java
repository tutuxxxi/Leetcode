package com.linmu.q1432;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/6 10:35
 * @description：leetcode q1432
 * @modified By：
 * @version: 1.0
 */
public class Q1432 {
    public static void main(String[] args) {
        new Solution().maxScore(new int[]{
                1,2,3,4,5,6,1
        }, 3);
    }
}

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length - k;
        int min = 0;
        int count = 0;
        int total = 0;


        //获取到前len位的总和
        for(int i = 0; i<len; i++){
            count += cardPoints[i];
        }

        //对后k位进行遍历
        total = min = count;
        for(int i = len; i < cardPoints.length; i++){
            count -= cardPoints[i-len] - cardPoints[i];
            min = Math.min(count, min);
            total += cardPoints[i];
        }

        return total - min;
    }
}
