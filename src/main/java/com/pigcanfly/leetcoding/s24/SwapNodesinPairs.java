package com.pigcanfly.leetcoding.s24;

/**
 * @author tobbyquinn
 * @date 2019/10/31
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode lastNode = null;
        boolean firstSwap = true;
        while (curr != null && curr.next != null) {
            ListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = curr;
            if (firstSwap) {
                head = nextNode;
                firstSwap = false;
            }
            if (lastNode != null) {
                lastNode.next = nextNode;
            }
            lastNode = curr;
            curr = curr.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
