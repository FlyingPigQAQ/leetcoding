package com.pigcanfly.leetcoding.s19;

import java.util.HashMap;

/**
 * 链表需要虚拟节点，否则在处理边界问题比较恶心
 *TODO: 两个指针间隔N算法
 *TODO: 先遍历长度，再修改
 * @author Tobby Quinn
 * @date 2019/06/17
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //边界问题
        if(head==null || head.next==null){
            return null;
        }

        HashMap<Integer, ListNode> indexMap = new HashMap<>();
        int index =0;
        ListNode iterHead=head;
        while(iterHead.next!=null){
            indexMap.put(index++,iterHead);
            iterHead=iterHead.next;

        }
        indexMap.put(index,head);
        //remove

        ListNode firstNode = indexMap.get(index-n);
        if(firstNode!=null){
            ListNode median = firstNode.next;
            ListNode last = median.next;
            firstNode.next=null;
            median.next=null;
            firstNode.next=last;
        }else{
            //说明头节点被删除
            return head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();
//        //例子1
        ListNode head = new ListNode(1);
        ListNode listNode = head.next = new ListNode(2);
//        ListNode listNode1 = listNode.next = new ListNode(3);
//        ListNode listNode2 = listNode1.next = new ListNode(4);
//        ListNode listNode3 = listNode2.next = new ListNode(5);
        ListNode listNode4 = obj.removeNthFromEnd(head, 2);
        while(listNode4!=null){
            System.out.println(listNode4.val+"->");
            listNode4=listNode4.next;
        }
//        //例子2
//        ListNode head = new ListNode(1);
//        ListNode listNode = obj.removeNthFromEnd(head, 0);
//        while(listNode!=null){
//            System.out.println(listNode.val+"->");
//            listNode=listNode.next;
//        }
    }

    //Definition for singly-linked list.
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
