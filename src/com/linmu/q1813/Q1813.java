package com.linmu.q1813;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author by lijun
 * @since 2023/1/16 8:43
 */
public class Q1813 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(0);
        scheduledExecutorService.schedule(() -> System.out.println("123"), 120, TimeUnit.SECONDS);
    }
}

class Solution {

}
