package com.linmu.q160;

/**
 * @author ：xxx_
 * @date ：Created in 2021/6/11 11:53 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q160 {
    public static void main(String[] args) {

    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode index1 = headA, index2 = headB;

        while(index1 != index2){
            index1 = index1.next == null ? headA : index1;
            index2 = index2.next == null ? headB : index2;
        }

        return index1;
    }
}
