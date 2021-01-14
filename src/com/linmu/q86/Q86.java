package com.linmu.q86;

public class Q86 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        listNode1.next = new ListNode(5);
        listNode1.next.next = new ListNode(7);
        listNode1.next.next.next = new ListNode(2);
        listNode1.next.next.next.next = new ListNode(1);

        ListNode listNode = new ListNode(1);
        new Solution().partition(listNode, 0);
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }

        ListNode otherHead = null;
        ListNode otherP = null;

        ListNode p1 = null;
        ListNode p2 = head;

        while(p2 != null){
            if(p2.val < x){
                //需要转移到另一个链表中

                if(otherHead == null){
                    otherHead = p2;
                    otherP = otherHead;
                }else{
                    otherP.next = p2;
                    otherP = otherP.next;
                }

                if(p1 == null){
                    //此时位于链表头
                    head = p2.next;
                }else{
                    //此时不在表头
                    p1.next = p2.next;
                }
            }else{
                p1 = p2;
            }

            p2 = p2.next;
        }

        if(otherP == null){
            return head;
        }else{
            otherP.next = head;
            return otherHead;
        }
    }
}
