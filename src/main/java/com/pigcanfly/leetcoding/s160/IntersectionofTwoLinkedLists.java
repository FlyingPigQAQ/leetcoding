package com.pigcanfly.leetcoding.s160;

/**
 * @author tobbyquinn
 * @date 2019/12/13
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==headB){
            return headA;
        }
        ListNode common = null, aPrevCommon=null, bPrevCommon=null;
        while (true) {
            ListNode dummyA = new ListNode(-1);
            dummyA.next = headA;
            //遍历A
            while (dummyA.next != common) {
                dummyA=dummyA.next;
            }
            aPrevCommon=dummyA;
            //遍历B
            ListNode dummyB = new ListNode(-1);
            dummyB.next = headB;
            while (dummyB.next != common) {
                dummyB=dummyB.next;
            }
            bPrevCommon=dummyB;
            if(aPrevCommon!=bPrevCommon){
                return common;
            }else {
                common=aPrevCommon;
            }
        }
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
