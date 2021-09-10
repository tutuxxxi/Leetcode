package com.linmu.Test;

import com.sun.org.apache.bcel.internal.generic.LoadClass;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xxx_
 */
public class Main{
    public static void main(String[] args) throws InterruptedException {
        String[] strings = new String[]{
                "123", "234", "345", "456"
        };

        List<String> strings1 = Arrays.asList(strings);
        strings1.remove("123");
    }
}

/*
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                lock.lock();
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread3");

        thread3.start();
 */
