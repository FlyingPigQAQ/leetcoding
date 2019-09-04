package com.pigcanfly.leetcoding.s141;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tobbyquinn
 * @date 2019/09/02
 */
class LinkedListCycleTest {
    private static final LinkedListCycle obj = new LinkedListCycle();

    @Test
    void hasCycle() {
        ListNode listNode = new ListNode(1);
        assertFalse(obj.hasCycle(listNode));
    }
    @Test
    void hasCycle1() {
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = listNode.next = new ListNode(2);
        ListNode listNode2 = listNode1.next = new ListNode(0);
        ListNode listNode3 = listNode2.next = new ListNode(-4);
        listNode3.next=listNode1;
        assertTrue(obj.hasCycle(listNode));
    }
    @Test
    void hasCycle2() {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = listNode.next = new ListNode(2);
        listNode1.next=listNode;
        assertTrue(obj.hasCycle(listNode));
    }
}