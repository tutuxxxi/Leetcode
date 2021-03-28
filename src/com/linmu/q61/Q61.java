package com.linmu.q61;

import java.util.SimpleTimeZone;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/27 1:18 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q61 {
    public static void main(String[] args) {

    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        ListNode res = head;

        while(temp != null){
            size++;
            temp = temp.next;
        }
        if(size == 0){
            return null;
        }
        k %= size;

        if(k != 0){
            
            int index = size - k;
            temp = head;

            while(index != 1){
                temp = temp.next;
                index--;
            }

            //此时需要断前接后
            //断前
            res = temp.next;
            temp.next = null;

            //接后
            temp = res;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = head;
        }

        return res;
    }
}
