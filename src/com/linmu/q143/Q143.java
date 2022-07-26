package com.linmu.q143;

/**
@author ：xxx_
@date ：Created in 2021/9/30 4:16 下午
@description：
@modified By：
@version:
 */
public class Q143 {
    public static void main(String[] args) {
        new Solution().reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
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
    public void reorderList(ListNode head) {
        if(head != null && head.next != null) {
            ListNode node = head.next;
            ListNode prev = null;
            while(node.next != null) {
                prev = node;
                node = node.next;
            }
            node.next = head.next;
            head.next = node;
            prev.next = null;

            reorderList(node.next.next);
        }
    }
}
