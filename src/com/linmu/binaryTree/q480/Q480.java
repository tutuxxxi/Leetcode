package com.linmu.binaryTree.q480;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/3 09:47
 * @description：leetcode q480
 * @modified By：
 * @version: 1.0
 */
public class Q480 {
    public static void main(String[] args) {

    }
}


//class Solution {
//    public double[] medianSlidingWindow(int[] nums, int k) {
//        if(nums.length == 0 || k == 0){
//            return new double[0];
//        }
//
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        double[] res = new double[nums.length - k + 1];
//        int index = 0;
//
//        for(int i = 0; i<k; i++){
//            queue.offer(nums[i]);
//        }
//        res[index++] = queue.size()%2 == 0 ?
//    }
//}