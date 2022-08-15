package com.linmu.q641;

/**
 * @author by lijun
 * @date 2022/8/15 8:26
 */
public class Q641 {
    public static void main(String[] args) {
        //["insertFront","getRear","isFull","deleteLast","insertFront","getFront"]
        //[[4],[],[],[],[4],[]]
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1));
        System.out.println(myCircularDeque.insertLast(2));
        System.out.println(myCircularDeque.insertFront(3));
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.isFull());
        System.out.println(myCircularDeque.deleteLast());
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.getFront());
    }
}

class MyCircularDeque {

    private int[] arr;

    private int preIndex, lastIndex;

    private int size, length;

    public MyCircularDeque(int k) {
        arr = new int[k];
        length = k;
        preIndex = 0;
        lastIndex = nextStep(lastIndex);
    }

    public boolean insertFront(int value) {
        if(!isFull()) {
            arr[preIndex] = value;
            preIndex = preStep(preIndex);
            size++;
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if(!isFull()) {
            arr[lastIndex] = value;
            lastIndex = nextStep(lastIndex);
            size++;
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if(!isEmpty()) {
            preIndex = nextStep(preIndex);
            size--;
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if(!isEmpty()) {
            lastIndex = preStep(lastIndex);
            size--;
            return true;
        }
        return false;
    }

    public int getFront() {
        if(!isEmpty()) {
            return arr[nextStep(preIndex)];
        }
        return -1;
    }

    public int getRear() {
        if(!isEmpty()) {
            return arr[preStep(lastIndex)];
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == length;
    }

    private int preStep(int index) {
        return (length + index - 1) % length;
    }

    private int nextStep(int index) {
        return (index + 1) % length;
    }
}
