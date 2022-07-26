package com.linmu.q725;

import java.util.Arrays;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/22 8:35 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q725 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(Arrays.toString(new Solution().splitListToParts(node, 5)));
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        ListNode[] res = new ListNode[k];

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        int per = count / k;
        int surplus = count % k;

        temp = head;
        for (int i = 0; i < k; i++) {
            res[i] = temp;
            for (int j = 0; j < per + (surplus > 0 ? 1 : 0) - 1; j++) {
                temp = temp.next;
            }
            surplus--;
            if (temp == null){
                break;
            }
            ListNode next = temp.next;
            temp.next = null;
            temp = next;
        }
        return res;
    }
}
