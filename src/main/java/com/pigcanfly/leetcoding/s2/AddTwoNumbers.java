package com.pigcanfly.leetcoding.s2;

/**
 * 该题参与操作的字符会溢出long类型
 * @author Tobby Quinn
 * @date 2019/06/21
 */
public class AddTwoNumbers {
    //此方法不可行，会整型溢出
    public ListNode UnAddTwoNumbers(ListNode l1, ListNode l2) {
        int index=0;
        long l1Int=0, l2Int=0;
        while(l1!=null || l2!=null){
            if(l1!=null){
                l1Int += l1.val * ((long)Math.pow(10,index));
                l1=l1.next;
            }
            if(l2!=null){
                l2Int += l2.val * ((long)Math.pow(10,index));
                l2=l2.next;
            }
            index++;
        }
        ListNode dummyHead=new ListNode(0);
        ListNode iterHead=dummyHead;
        long result = l1Int+l2Int;
        while (result/10!=0){
            int tmpVal = (int)(result % 10);
            ListNode currentNode = new ListNode(tmpVal);
            iterHead.next=currentNode;
            iterHead=currentNode;
            result=result/10;
        }

        //边界问题，最后的余数
        ListNode currentNode = new ListNode((int)result);
        iterHead.next=currentNode;

        return dummyHead.next;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return null;

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
        obj.addTwoNumbers(l1,l2);

      //  System.out.println(9999999991+9);
    }
   public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
}
