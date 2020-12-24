package com.linmu.q2;

public class Q2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode l2 = new ListNode(0, new ListNode(6, new ListNode(4)));
        System.out.println(new Solution().addTwoNumbers(l1,l2));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return val + "," + next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;

        if(l2 == null)
            return l1;

        int temp = 0;
        ListNode list = new ListNode();
        while(true){

            if(l1 != null)
                temp += l1.val;
            if(l2 != null)
                temp += l2.val;

            if(temp > 9){
                temp %= 10;
                list.val = temp;
                temp = 1;
            }else{
                list.val = temp;
                temp = 0;
            }

            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;

            if(l1 == null && l2 == null && temp == 0)
                break;

            list.next = new ListNode();
            list = list.next;

        }
        return list;
    }
}