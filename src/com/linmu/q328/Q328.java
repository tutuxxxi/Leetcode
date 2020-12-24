package com.linmu.q328;

public class Q328 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6,
                                                        new ListNode(7,
                                                                new ListNode(8,
                                                                        new ListNode(9, null)))))))));

        new Solution().oddEvenList(head);
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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode ptr1, ptr2;
        ptr1  = head;
        ptr2 = ptr1.next;

        while(ptr2 != null && ptr2.next != null){
            ListNode temp = ptr1.next;
            ptr1.next = ptr2.next;
            ptr2.next = ptr2.next.next;
            ptr1.next.next = temp;

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return head;
    }
}
