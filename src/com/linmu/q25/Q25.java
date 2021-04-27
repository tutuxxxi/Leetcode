package com.linmu.q25;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/19 8:57 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q25 {
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        for(int i = 0; i < k; i++){
            if(temp == null){
                return head;
            }
            temp = temp.next;
        }

        ListNode newTail = head;
        ListNode operatorPre = head;
        ListNode operatorPost = head.next;


        while(operatorPost != temp){
            ListNode tempNext = operatorPost.next;
            operatorPost.next = operatorPre;

            operatorPre = operatorPost;
            operatorPost = tempNext;
        }

        newTail.next = reverseKGroup(temp, k);
        return operatorPre;
    }
}
