package com.pigcanfly.leetcoding.s206;

/**
 * @author Tobby Quinn
 * @date 2019/08/05
 */
public class ReverseLinkedList {

    public  ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        reverseList(head,dummyHead);
        return dummyHead.next;
    }
    public ListNode reverseList(ListNode head,ListNode dummyHead) {
        if(head==null){
            return dummyHead;
        }
        reverseList(head.next,dummyHead).next=head;
        head.next=null;
        return head;
    }


    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    public ListNode reverseList1(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
        root.next=l2;
//        l2.next=l3;
//        l3.next=null;
//        ListNode listNode = new ReverseLinkedList().reverseList(root);
//        System.out.println(listNode);
        new ReverseLinkedList().reverseList1(root);
    }
}
