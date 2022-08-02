package com.linmu.q622;

/**
 * @author by lijun
 * @date 2022/8/2 13:25
 */
public class Q622 {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
    }
}

class MyCircularQueue {

    private int size;

    private int num;

    private int frontIndex, endIndex;

    private int[] arr;

    public MyCircularQueue(int k) {
        arr = new int[k];
        size = k;
        frontIndex = endIndex = num = 0;
    }

    public boolean enQueue(int value) {
        if(!isFull()) {
            arr[endIndex] = value;
            endIndex = nextIndex(endIndex);
            num++;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if(!isEmpty()) {
            frontIndex = nextIndex(frontIndex);
            num--;
            return true;
        }
        return false;
    }

    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return arr[frontIndex];
    }

    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        return arr[frontIndex(endIndex)];
    }

    public boolean isEmpty() {
        return num == 0;
    }

    public boolean isFull() {
        return num == size && frontIndex == endIndex;
    }

    private int nextIndex(int index) {
        return (index + 1) % size;
    }

    private int frontIndex(int index) {
        return (index - 1 + size) % size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
