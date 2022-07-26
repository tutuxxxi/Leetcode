package com.linmu.q729;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author ：xxx_
 * @date ：Created in 2022/7/5 12:37
 * @description：
 * @modified By：
 * @version:
 */
public class Q729 {
    public static void main(String[] args) {
    }
}

class MyCalendar {

    TreeSet<int[]> set;

    public MyCalendar() {
        set = new TreeSet<>(Comparator.comparingInt(o -> o[0]));
    }

    public boolean book(int start, int end) {
        int[] arr = new int[]{start, end};
        for (int[] ints : set) {
            if(check(ints, arr)) {
                return false;
            }
        }
        set.add(arr);
        return true;
    }

    /**
     * 检查是否重合
     * @param a
     * @param b
     * @return
     */
    private static boolean check(int[] a, int[] b) {
        return !((a[0] < b[0] && a[1] <= b[0]) || (a[0] >= b[1] && a[1] > b[1]));
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
