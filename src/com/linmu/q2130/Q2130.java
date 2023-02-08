package com.linmu.q2130;

/**
 * @author by lijun
 * @since 2023/1/31 14:22
 */
public class Q2130 {
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
    public int pairSum(ListNode head) {
        int count = 0;
        ListNode operator = head;
        while(operator != null) {
            count++;
            operator = operator.next;
        }

        int[] mark = new int[count];
        count = 0;
        operator = head;
        while(operator != null) {
            mark[count++] = operator.val;
            operator = operator.next;
        }

        // 计算mark中最大孪生和
        int ans = Integer.MIN_VALUE;
        int num = (count / 2) - 1;
        for (int i = 0; i < num; i++) {
            int index = count - 1 - i;
            ans = Math.max(ans, mark[i] + mark[index]);
        }
        return ans;
    }
}
