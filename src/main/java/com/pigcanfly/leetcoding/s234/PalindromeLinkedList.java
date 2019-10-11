package com.pigcanfly.leetcoding.s234;

import java.util.List;
import java.util.Stack;

/**
 * @author tobbyquinn
 * @date 2019/10/09
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode p1 = head;
        while(p1!=null){
            stack.push(p1.val);
            p1=p1.next;
        }
        ListNode p2 = head;
        int half= stack.size()/2;
        for (int i = 0; i < half; i++) {
            if(p2.val!=stack.pop()){
                return false;
            }
            p2=p2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(1);
        head.next=h1;
        h1.next=h2;
        h2.next=h3;
        boolean palindrome = new PalindromeLinkedList().isPalindrome(head);
        System.out.println(palindrome);
    }
}

 class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
