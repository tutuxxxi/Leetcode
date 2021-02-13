package com.linmu.q1208;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/5 14:03
 * @description：leetcode q1208
 * @modified By：
 * @version: 1.0
 */
public class Q1208 {
    public static void main(String[] args) {
        new Solution().equalSubstring("anryddgaqpjdw",
                "zjhotgdlmadcf",
                5);
    }
}

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        int cost = 0;
        int maxLength = 0;
        int preIndex, endIndex;
        preIndex = endIndex = 0;

        //在尾指针没有到达末尾之前
        while (endIndex != tchars.length){

            //确定当前位置的消耗
            cost += Math.abs(schars[endIndex] - tchars[endIndex]);

            while(cost > maxCost && preIndex < endIndex){
                //如果当前超值，就移动头指针
                cost -= Math.abs(schars[preIndex] - tchars[preIndex++]);
            }

            if(cost > maxCost){
                //当前位置无法被取
                preIndex = endIndex = endIndex+1;
                cost = 0;
            }else{
                //更新最长距离
                maxLength = Math.max(maxLength, ++endIndex - preIndex);
            }
        }

        return maxLength;
    }
}