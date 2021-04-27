package com.linmu.q24;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/19 8:52 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q24 {
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
    public ListNode swapPairs(ListNode head) {
        //不足两个结点
        if(head == null || head.next == null){
            return head;
        }

        //固定第二节点为头节点
        ListNode res = head.next;
        //修改头节点的下一结点为交换后的第三节点
        head.next = swapPairs((res.next));
        //修改第二节点的后节点为第一结点
        res.next = head;

        return res;
    }
}