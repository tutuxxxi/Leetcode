package com.linmu.q457;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author by lijun
 * @since 2023/1/31 10:43
 */
public class Q457 {
    public static void main(String[] args) {
        //[-2,1,-1,-2,-2]
        new Solution().circularArrayLoop(new int[]{-2, 1, -1, -2, -2});
    }
}

class Solution {

    public boolean circularArrayLoop(int[] nums) {
        Map<Integer, Integer> linkMap = new HashMap<>(16);
        Map<Integer, Integer> degreeMap = new HashMap<>(16);

        int length = nums.length;
        for (int index = 0; index < length; index++) {
            int moveIndex = move(index, length, nums[index]);

            // 特殊的，自己指向自己(长度为1的环)不被记录， 符号不同的不被记录
            if (index != moveIndex && nums[index] * nums[moveIndex] > 0) {
                degreeMap.put(moveIndex, degreeMap.getOrDefault(moveIndex, 0) + 1);
                linkMap.put(index, moveIndex);
            }
        }

        // top sort
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (!degreeMap.containsKey(i)) {
                deque.addLast(i);
            }
        }

        while (!deque.isEmpty()) {
            Integer index = deque.removeFirst();
            Integer link = linkMap.get(index);
            if (link != null) {
                Integer degree = degreeMap.get(link);
                if (degree == 1) {
                    deque.addLast(link);
                    degreeMap.remove(link);
                } else {
                    degreeMap.put(link, degree - 1);
                }
            }
        }

        return degreeMap.size() > 1;
    }

    private static int move(int index, int length, int step) {
        step %= length;
        return (index + length + step) % length;
    }
}
