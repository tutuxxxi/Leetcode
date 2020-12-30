package com.linmu.q1046;

import java.util.PriorityQueue;

public class Q1046 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i : stones){
            queue.offer(i);
        }

        while(queue.size() > 1){
            Integer temp = queue.poll() - queue.poll();
            if(temp != 0){
                queue.offer(temp);
            }
        }

        if(queue.size() == 0){
            return 0;
        }else{
            return queue.poll();
        }
    }
}
