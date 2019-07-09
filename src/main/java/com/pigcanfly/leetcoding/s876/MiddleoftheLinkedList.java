package com.pigcanfly.leetcoding.s876;

/**
 * @author Tobby Quinn
 * @date 2019/07/05
 */
public class MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode[] nodes = new ListNode[101];
        int size=0;
        while(head!=null){
            nodes[size++]=head;
            head=head.next;
        }
        return nodes[size/2];

    }

    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
}
