package com.pigcanfly.leetcoding.s141;

/**
 * @author tobbyquinn
 * @date 2019/09/02
 */
public class LinkedListCycle {
    //该方法的弊端是不允许value重复
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode dummyHead1 = head, dummyHead2 = head;
        while (true) {
            dummyHead1 = dummyHead1.next;
            dummyHead2 = dummyHead2.next;
            if (dummyHead1 == null || dummyHead2 == null) {
                return false;
            }
            dummyHead2 = dummyHead2.next;
            if (dummyHead2 == null) {
                return false;
            }
            if (dummyHead2.val == dummyHead1.val) {
                return true;
            }
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast== null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
