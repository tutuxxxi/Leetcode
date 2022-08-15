package com.linmu.q636;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by lijun
 * @date 2022/8/11 16:01
 */
public class Q636 {
    public static void main(String[] args) {
        new Solution().exclusiveTime(2, Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6"));
    }
}

class Solution {

    private static final String START = "start";

    private static final String END = "end";

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<Process> stack = new LinkedList<>();
        for (String log : logs) {
            String[] split = log.split(":");
            int nowTime = Integer.parseInt(split[2]);

            if(START.equals(split[1])) {
                // create new and set preTime = nowTime
                Process process = new Process(split[0], nowTime, 0);
                // stop pre-process
                if(!stack.isEmpty()) {
                    stack.peekFirst().pause(nowTime);
                }
                process.start(nowTime);
                stack.offerFirst(process);
            }else if(END.equals(split[1])){
                // remove process
                Process process = stack.pollFirst();
                process.pause(nowTime + 1);
                ans[Integer.parseInt(process.index)] = process.nowRunTime;
                // restart pre-process
                if(!stack.isEmpty()) {
                    stack.peekFirst().start(nowTime + 1);
                }
            }
        }
        return ans;
    }
}


class Process {
    String index;
    int preTime;
    int nowRunTime;

    public Process(String index, int preTime, int nowRunTime) {
        this.index = index;
        this.preTime = preTime;
        this.nowRunTime = nowRunTime;
    }

    public void pause(int nowTime) {
        nowRunTime += nowTime - preTime;
        preTime = -1;
    }

    public void start(int nowTime) {
        preTime = nowTime;
    }
}
