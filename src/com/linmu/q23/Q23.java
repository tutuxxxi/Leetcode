package com.linmu.q23;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
@author ：xxx_
@date ：Created in 2021/4/17 1:33 下午
@description：
@modified By：
@version:
 */
public class Q23 {
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
    public ListNode mergeKLists(ListNode[] lists) {
        //当前存在结点的链表个数
        Queue queue = new LinkedList();
        for(int i = 0; i<lists.length; i++){
            if(lists[i] != null){
                queue.offer(i);
            }
        }

        ListNode head = new ListNode();
        ListNode temp = head;

        while(!queue.isEmpty()){
            int minIndex = (Integer) queue.poll();
            int length = queue.size();
            for(int i = 0; i<length; i++){
                int tempIndex = (Integer) queue.poll();

                if(lists[tempIndex].val < lists[minIndex].val){
                    queue.offer(minIndex);
                    minIndex = tempIndex;
                }else{
                    queue.offer(tempIndex);
                }
            }


            //此时minIndex是值最小的链表下标

            //连接
            temp.next = lists[minIndex];
            //头转移
            lists[minIndex] = lists[minIndex].next;
            if(lists[minIndex] != null){
                queue.offer(minIndex);
            }
            //断后
            temp = temp.next;
            temp.next = null;
        }

        return head.next;
    }
}