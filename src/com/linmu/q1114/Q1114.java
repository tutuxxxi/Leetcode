package com.linmu.q1114;

/**
 * @author by lijun
 * @since 2023/2/7 17:41
 */
public class Q1114 {
    public static void main(String[] args) {

    }
}

class Foo {

    private final Object object = new Object();

    private boolean firstFinish = false;

    private boolean secondFinish = false;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (object) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFinish = true;
            object.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (object) {
            while(!firstFinish) {
                object.wait();
            }

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFinish = true;
            object.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (object) {
            while(!secondFinish) {
                object.wait();
            }

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
