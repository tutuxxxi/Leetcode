package com.linmu.q82;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/25 5:16 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q82 {
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = null;
        ListNode tail = null;

        ListNode temp = head;

        while(temp != null){

            //若满足则直接跳过该情况
            if(temp.next != null && temp.next.val == temp.val){
                while(temp.next != null && temp.next.val == temp.val){
                    temp = temp.next;
                }
                temp = temp.next;
                continue;
            }else{
                if(root == null){
                    tail = root = temp;
                }else{
                    tail.next = temp;
                    tail = tail.next;
                }
                temp = temp.next;
                tail.next = null;
            }
        }

        return root;
    }
}