package com.pigcanfly.leetcoding.s203;

/**
 * @author tobbyquinn
 * @date 2019/11/05
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode curr = dummyHead;
        while (curr.next!=null){
            if(curr.next.val==val){
                ListNode third = curr.next.next;
                curr.next.next=null;
                curr.next=third;
            }else{
                curr=curr.next;
            }
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
