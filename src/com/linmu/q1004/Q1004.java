package com.linmu.q1004;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/19 11:08
 * @description：leetcode q1004
 * @modified By：
 * @version: 1.0
 */
public class Q1004 {
    public static void main(String[] args) {
        new Solution().longestOnes(new int[]{
                1,1,1,0,0,0,1,1,1,1,0
        }, 2);
    }
}

class Solution {
    public int longestOnes(int[] A, int K) {
        int maxLength = 0;
        int start, end;
        start = end = 0;

        //当没有遍历完时继续遍历
        while(end < A.length){

            //需要将当前位由0变成1
            if(A[end] == 0){

                if(K == 0){
                    //开始回收之前的0位
                    maxLength = Math.max(maxLength, end - start);

                    while(A[start] != 0 && start < end){
                        start++;
                    }

                    //此时无论是回收0的位置成功还是失败，都会将start和end往后移：
                    //      如果成功了，由于当前start为0位，需要后移，end为消耗位，需要后移
                    //      如果失败，则end位不可取，start = end = end+1；
                    start++;
                }else{
                    //直接改变
                    K--;
                }
            }
            end++;
        }

        return Math.max(maxLength, end-start);
    }
}