package com.linmu.Test;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author xxx_
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        String str = null;
        switch (str) {
            case "1": str = "1";
        }
        System.out.println();

//        ExecutorService executor = new ThreadPoolExecutor(1, 1,
//                0, TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(), r -> new Thread(r, "work thread"));
//
//
//        // 模拟用户线程1 提交10个任务并等待返回
//        Thread user1 = new Thread(() -> {
//            Collection<Callable<Integer>> callables = new ArrayList<>();
//            for (int i = 0; i < 10; i++) {
//                final int var = i;
//                callables.add(() -> {
//                    Thread.sleep(100);
//                    System.out.println(Thread.currentThread().getName() + " finish the work" + var);
//                    return var;
//                });
//            }
//
//            try {
//                executor.invokeAll(callables);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }, "user1");
//        user1.setDaemon(true);
//        user1.start();
//
//
//        // 模拟用户线程2 试图关闭执行器
//        new Thread(() -> {
//            try {
//                Thread.sleep(400);
//                executor.shutdownNow();
//                System.out.println(Thread.currentThread().getName() + " shutdown the executor");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }, "user2").start();
    }
}


