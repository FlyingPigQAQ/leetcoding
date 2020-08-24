package com.pigcanfly.leetcoding.s1265;

import java.util.Stack;

/**
 * @author tobbyquinn
 * @date 2020/01/06
 */
public class PrintImmutableLinkedListinReverse {
    public void printLinkedListInReverse1(ImmutableListNode head) {
        ImmutableListNode[] immutableListNodes = new ImmutableListNode[1000];
        int index=0;
        while(head!=null){
           immutableListNodes[index++]=head;
           head=head.getNext();
        }
        for (int i = index-1; i >=0; i--) {
            immutableListNodes[i].printValue();
        }
    }
    /**
     * recursive
     * O(N)空间复杂度
     */
    public void printLinkedListInReverse2(ImmutableListNode head) {
        if(head==null){
            return;
        }
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }

    /**
     * O(N/2)空间复杂度
     */
    public void printLinkedListInReverse3(ImmutableListNode head) {
        Stack<ImmutableListNode> stack = new Stack<>();
        //push the firstNode,thirdNode,fifthNode ....
        int size=0;
        while(head!=null){
            if(size%2==0){
                stack.push(head);
            }
            head=head.getNext();
            size++;
        }
        while (!stack.isEmpty()){
            ImmutableListNode pop = stack.pop();
            ImmutableListNode nextNode = pop.getNext();
            if(nextNode !=null){
                nextNode.printValue();
            }
            pop.printValue();
        }
    }

    /**
     * O(sqrt(N))空间复杂度
     */
    public void printLinkedListInReverse(ImmutableListNode head) {
        int size = getSize(head),sqrtSize=(int)Math.sqrt(size)+1;
        Stack<ImmutableListNode> stack = new Stack<>();
        ImmutableListNode iterNode=head;
        int i=0;
        while(iterNode!=null){
            if(i%sqrtSize==0){
                stack.push(iterNode);
            }
            iterNode=iterNode.getNext();
        }
        ImmutableListNode lastEndNode=null;
        while(!stack.isEmpty()){
            ImmutableListNode popHead = stack.pop(),tempNode=popHead;
            Stack<ImmutableListNode> subStack = new Stack<>();
            while(popHead!=null){
                if(lastEndNode==popHead){
                    break;
                }
                subStack.push(popHead);
                popHead=popHead.getNext();
            }
            while (!subStack.isEmpty()){
                subStack.pop().printValue();
            }
            lastEndNode=tempNode;
        }
    }
    private int getSize(ImmutableListNode head){
        int size=0;
        while (head!=null){
            size++;
            head=head.getNext();
        }
        return size;
    }
}
interface ImmutableListNode {
      public void printValue(); // print the value of this node.
      public ImmutableListNode getNext(); // return the next node.
  };
