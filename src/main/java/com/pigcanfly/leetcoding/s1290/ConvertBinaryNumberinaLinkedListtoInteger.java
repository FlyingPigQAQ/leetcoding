package com.pigcanfly.leetcoding.s1290;

/**
 * @author tobbyquinn
 * @date 2019/12/16
 */
public class ConvertBinaryNumberinaLinkedListtoInteger {
    public int getDecimalValue1(ListNode head) {
        int size=0,res=0;
        ListNode iter=head;
        while (iter!=null){
            size++;
            iter=iter.next;
        }
        iter=head;
        while (iter!=null){
            if(iter.val==1){
                res+=Math.pow(2,size-1);
            }
            size--;
            iter=iter.next;
        }
        return res;
    }
    public int getDecimalValue(ListNode head) {
        int res=0;
        while (head!=null){
            res<<=1;
            res+=head.val;
            head=head.next;
        }
        return res;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
