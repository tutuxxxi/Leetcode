package com.linmu.q2365;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by lijun
 * @since 2023/1/30 14:58
 */
public class Q2365 {
    public static void main(String[] args) {
        System.out.println(new Solution().taskSchedulerII(new int[]{1, 2, 1, 2, 3, 1}, 3));
    }
}

class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        int count = 1;
        Map<Integer, Integer> mark = new HashMap<>(16);

        for (int task : tasks) {
            Integer orDefault = mark.get(task);
            if(orDefault == null) {
                mark.put(task, count++);
            }else {
                count = Math.max(orDefault + space + 1, count);
                mark.put(task, count++);
            }
        }
        return --count;
    }
}
