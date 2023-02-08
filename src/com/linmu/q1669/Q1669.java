package com.linmu.q1669;

/**
 * @author by lijun
 * @since 2023/1/30 8:49
 */
public class Q1669 {
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode res = list1;

        // 获取list2的尾指针
        ListNode tail2 = list2;
        while(tail2.next != null) {
            tail2 = tail2.next;
        }

        // 连接 list1当前位置 -> list2头; list2头 -> list1当前位置下一节点
        if(a == 0) {
            res = list2;
            tail2.next = list1;
        } else {
            ListNode tail1 = list1;
            for (int i = 1; i < a; i++) {
                tail1 = tail1.next;
            }
            tail2.next = tail1.next;
            tail1.next = list2;
        }

        // 继续移动 b - a + 1个结点
        for (int i = a; i <= b; i++) {
            tail2.next = tail2.next.next;
        }

        return res;
    }
}
