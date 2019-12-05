package com.pigcanfly.leetcoding.s328;

/**
 * @author tobbyquinn
 * @date 2019/11/08
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummyHead=new ListNode(0);
        ListNode dummyEvenHead=new ListNode(0);

        ListNode odd=head;
        dummyHead.next=odd;
        ListNode even=head.next;
        dummyEvenHead.next=even;
        ListNode curr=even.next;
        odd.next=null;
        even.next=null;
        int index=3;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next=null;
            if(index++%2==0){
                even.next=curr;
                even=even.next;
                curr=next;
            }else{
                 odd.next=curr;
                 odd=odd.next;
                 curr=next;
            }
        }
        odd.next=dummyEvenHead.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        System.out.println(0^1);
        System.out.println(1^1);
    }
}

class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
