package com.linmu.q1117;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author by lijun
 * @date 2022/8/24 8:33
 */
public class Q1117 {
    public static void main(String[] args) {

    }
}

class H2O {

    private final CyclicBarrier cyclicBarrier;

    private final Semaphore semaphore;

    private final ReentrantLock reentrantLock;

    public H2O() {
        cyclicBarrier = new CyclicBarrier(3);
        semaphore = new Semaphore(2);
        reentrantLock = new ReentrantLock();
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException{
        semaphore.acquire();
        try {
            cyclicBarrier.await();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        reentrantLock.lock();
        try {
            cyclicBarrier.await();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }
}
