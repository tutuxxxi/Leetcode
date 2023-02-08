package com.linmu.m02_06;

/**
 * @author by lijun
 * @since 2023/1/9 11:15
 */
public class M02_06 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);

        System.out.println(new Solution().isPalindrome(listNode));
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null && head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode list1 = head;
        ListNode list2 = reverse(slow.next);
        slow.next = null;
        return compare(list1, list2);
    }

    private ListNode reverse(ListNode root) {
        if(root == null) {
            return null;
        }

        ListNode pre = null, next;
        ListNode curr = root;
        while((next = curr.next) != null) {
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        curr.next = pre;
        return curr;
    }

    private boolean compare(ListNode list1, ListNode list2) {
        while(list1 != null && list2 != null) {
            if(list1.val != list2.val) {
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return list1 == null && list2 == null;
    }
}
