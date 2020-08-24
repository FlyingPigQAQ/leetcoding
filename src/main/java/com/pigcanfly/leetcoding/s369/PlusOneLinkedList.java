package com.pigcanfly.leetcoding.s369;

/**
 * @author tobbyquinn
 * @date 2020/05/26
 */
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        plusOne(head, dummyHead);
        return dummyHead.val == 1 ? dummyHead : head;
    }

    private void plusOne(ListNode head, ListNode parent) {
        if (head == null) {
            parent.val += 1;
            return;
        }
        plusOne(head.next, head);
        if (head.val > 9) {
            head.val %= 10;
            parent.val += 1;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
