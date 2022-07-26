package com.linmu.q109;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/18 3:41 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q109 {
    public static void main(String[] args) {
        new Solution().sortedListToBST(new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9))))));
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head != null) {
            ListNode fast = head, slow = head, preSlow = null;

            // 快慢指针移动
            while(fast != null) {
                fast = fast.next;
                if(fast != null){
                    fast = fast.next;
                    preSlow = slow;
                    slow = slow.next;
                }
            }

            TreeNode treeNode = new TreeNode(slow.val);
            treeNode.right = sortedListToBST(slow.next);
            if(preSlow != null) {
                preSlow.next = null;
                treeNode.left = sortedListToBST(head);
            }
            return treeNode;
        }
        return null;
    }
}
