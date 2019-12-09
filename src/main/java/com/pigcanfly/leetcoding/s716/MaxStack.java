package com.pigcanfly.leetcoding.s716;

import java.util.LinkedList;

/**
 * @author tobbyquinn
 * @date 2019/12/06
 */
public class MaxStack {
    ListNode dummyHead;
    ListNode tail=null;
    public MaxStack() {
        this.dummyHead=new ListNode(-1,null,null);
    }

    public void push(int x) {
        if(tail==null){
            tail=new ListNode(x,dummyHead,null);
            dummyHead.next=tail;
        }else{
            ListNode newNode = new ListNode(x, tail, null);
            tail.next=newNode;
            tail=newNode;
        }
    }

    public int pop() {
        ListNode prev = tail.prev;
        ListNode curr = tail;
        if(prev==dummyHead){
            tail=null;
        }else{
            tail=prev;
        }
        return curr.val;
    }

    public int top() {
        return tail.val;
    }

    public int peekMax() {
        ListNode max = findMax();
        return max.val;
    }

    public int popMax() {
        ListNode max = findMax();
        ListNode next = max.next;
        ListNode prev = max.prev;
        max.prev=null;
        max.next=null;
        prev.next=next;
        if(next!=null){
            next.prev=prev;
        }
        if(max==tail ){
            if( prev!=dummyHead){
                tail=prev;
            }else {
                tail=null;
            }
        }
        return max.val;
    }
    ListNode findMax(){
        ListNode iter=tail;
        ListNode max=tail;
        while (iter!=dummyHead){
            if(max.val<iter.val){
                max=iter;
            }
            iter=iter.prev;
        }
        return max;
    }

    private class ListNode{
        Integer val;
        ListNode prev;
        ListNode next;
        ListNode(Integer val,ListNode prev,ListNode next){
            this.val=val;
            this.prev=prev;
            this.next=next;
        }
    }

    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        stack.top();
        stack.popMax();
        stack.top();
        stack.peekMax();
        stack.pop();
        stack.top();
    }

}
