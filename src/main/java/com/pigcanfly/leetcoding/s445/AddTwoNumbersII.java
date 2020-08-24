package com.pigcanfly.leetcoding.s445;

import java.util.Stack;

/**
 * @author tobbyquinn
 * @date 2020/05/13
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1!=null || l2!=null){
            if(l1!=null){
                stack1.push(l1.val);
                l1=l1.next;
            }
            if(l2!=null){
                stack2.push(l2.val);
                l2=l2.next;
            }
        }
        int carry=0;
        ListNode dummyHead = new ListNode();
        while (carry!=0 || !stack1.isEmpty() || !stack2.isEmpty()){
            int num1=0;
            if(!stack1.isEmpty()){
                num1=stack1.pop();
            }
            int num2=0;
            if(!stack2.isEmpty()){
                num2=stack2.pop();
            }
            int mod=(num1+num2+carry)%10;
            carry=(num1+num2+carry)/10;
            ListNode listNode = new ListNode(mod);
            ListNode last = dummyHead.next;
            listNode.next=last;
            dummyHead.next=listNode;
        }
        return dummyHead.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
