package com.pigcanfly.leetcoding.s83;

/**
 * @author Tobby Quinn
 * @date 2019/06/17
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * 时间复杂度O(N)
     * 空间复杂度O(L)
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummp = new ListNode(0);
        if (head == null) {
            return null;
        }
        dummp.next = new ListNode(head.val);
        ListNode iterHead = dummp.next;
        while (head != null) {
            if (iterHead.val != head.val) {
                ListNode insNode = new ListNode(head.val);
                iterHead.next = insNode;
                iterHead = insNode;
            }
            head = head.next;
        }
        return dummp.next;

    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList obj = new RemoveDuplicatesFromSortedList();
        ListNode head = new ListNode(1);
        ListNode listNode = head.next = new ListNode(1);
        ListNode listNode1 = listNode.next = new ListNode(2);
        ListNode listNode2 = obj.deleteDuplicates(head);
        while (listNode2 != null) {
            System.out.println(listNode2.val + "->");
            listNode2 = listNode2.next;
        }
    }


    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
