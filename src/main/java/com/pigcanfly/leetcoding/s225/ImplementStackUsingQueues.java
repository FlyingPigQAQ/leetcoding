package com.pigcanfly.leetcoding.s225;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Tobby Quinn
 * @date 2019/06/13
 */
//TODO:queue1
public class ImplementStackUsingQueues {
    ArrayDeque<Integer> q1 ;
    ArrayDeque<Integer> q2;
    ArrayDeque<Integer> swap;
    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
      q1 = new ArrayDeque<>();
      q2 = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size()>1){
            Integer pop = q1.remove();
            q2.offer(pop);
        }
        int popResult=q1.remove();
        swap=q1;
        q1=q2;
        q2=swap;
        return popResult;
    }

    /** Get the top element. */
    public int top() {

       return q1.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size()==0;
    }

    public int size(){
        return q1.size()+q2.size();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();

        stack.push(1);
        stack.push(2);
        int top = stack.top();// returns 2
        System.out.println(top);
        int pop = stack.pop();// returns 2
        System.out.println(pop);
        boolean empty = stack.empty();// returns false
        System.out.println(empty);
    }

}
