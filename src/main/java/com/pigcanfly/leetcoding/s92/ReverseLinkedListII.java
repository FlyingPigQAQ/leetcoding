package com.pigcanfly.leetcoding.s92;

/**
 * @author tobbyquinn
 * @date 2020/01/03
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        ListNode startNode = null, endNode=null,dummyHead = new ListNode(-1),subNode=null;
        dummyHead.next=head;
        ListNode iterNode=head;
        for (int i = 1; iterNode != null; i++) {
            ListNode nextNode = iterNode.next;
            if(m==1){
                startNode=dummyHead;
            }else if(i==m-1){
                startNode=iterNode;
            }
            if(i==n){
                endNode=iterNode;
                startNode.next.next=endNode.next;
                startNode.next=endNode;
                endNode.next=subNode;
            }
            if(i>=m && i<n){
                if(subNode==null){
                    subNode=iterNode;
                }else {
                    iterNode.next=subNode;
                    subNode= iterNode;
                }
            }
            iterNode=nextNode;
        }
        return dummyHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
