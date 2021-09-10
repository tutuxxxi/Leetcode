package com.linmu.q313;

import java.security.Key;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ：xxx_
 * @date ：Created in 2021/8/9 8:45 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q313 {
    public static void main(String[] args) {
        new Solution().nthSuperUglyNumber(12, new int[]{
           2,7,13,19
        });
    }
}

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> (o[0] + o[1])));
        for(int i : primes){
            queue.add(new Integer[]{i, i});
        }

        for(int i = 0; i<n; i++){
            Integer[] peek = queue.poll();
            peek[0] += peek[1];
            queue.offer(peek);
        }

        return 1;
    }
}
