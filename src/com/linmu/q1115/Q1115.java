package com.linmu.q1115;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author by lijun
 * @since 2023/2/7 17:49
 */
public class Q1115 {
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(10);
        new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();



    }
}

class FooBar {
    private int n;

    private final ReentrantLock lock = new ReentrantLock();

    private final Condition firstCondition = lock.newCondition();

    private final Condition secondCondition = lock.newCondition();

    private AtomicInteger mask = new AtomicInteger(0);


    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        while(!mask.compareAndSet(0, 1)){}
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();

                secondCondition.signal();
                firstCondition.await();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        while(!mask.compareAndSet(1, 0)){}
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                secondCondition.await();

                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();

                firstCondition.signal();
            }finally {
                lock.unlock();
            }
        }
    }
}
