package com.pigcanfly.leetcoding.s2;

/**
 * 该题参与操作的字符会溢出long类型
 *
 * @author Tobby Quinn
 * @date 2019/06/21
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyNode = new ListNode(0);
        ListNode iterHead = dummyNode;
        while (carry != 0 || l1 != null || l2 != null) {
            int current = carry;
            if (l1 != null) {
                current += l1.val;
                l1=l1.next;
            }
            if (l2 != null) {
                current += l2.val;
                l2=l2.next;
            }
            if (current > 9) {
                carry = 1;
                current -= 10;
            } else {
                carry = 0;
            }
            ListNode currNode = new ListNode(current);
            iterHead.next = currNode;
            iterHead = currNode;
        }
        return dummyNode.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = l1.next = new ListNode(9);
        ListNode l111 = l11.next = new ListNode(9);
        ListNode l1111 = l111.next = new ListNode(9);
        ListNode l11111 = l1111.next = new ListNode(9);
        ListNode l111111 = l11111.next = new ListNode(9);
        ListNode l1111111 = l111111.next = new ListNode(9);
        ListNode l11111111 = l1111111.next = new ListNode(9);
        ListNode l111111111 = l11111111.next = new ListNode(9);
        ListNode listNode = l111111111.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        AddTwoNumbers obj = new AddTwoNumbers();
        obj.addTwoNumbers(l1, l2);

        //  System.out.println(9999999991+9);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
