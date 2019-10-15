package com.pigcanfly.leetcoding.s415;

import com.pigcanfly.leetcoding.s2.AddTwoNumbers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author tobbyquinn
 * @date 2019/10/11
 */
public class AddStrings {
//    public String addStrings1(String num1, String num2) {
//        char[] res = new char[]{'0','0','0','0','0'};
//        int index1=0,index2=0;
//        String max=num1.length()>=num2.length()?num1:num2;
//        String min=num1.length()>=num2.length()?num2:num1;
//        for (int i = min.length()-1; i >=0 ; i--) {
//            res[index1++]=min.charAt(i);
//        }
//        index1=0;
//        int carry=0;
//        for (int i = max.length()-1; i >=0 ; i--) {
//            int num = max.charAt(i)-48;
//            int sum = num+(res[index1++]-48)+carry;
//            if(sum>9){
//                res[index2++]=(char)(sum-10+48);
//                carry=1;
//            }else{
//                res[index2++]=(char)(sum+48);
//                carry=0;
//            }
//        }
//        if(carry==1){
//            res[index2++]=(char)(carry+48);
//        }
//        return new StringBuilder(new String(res,0,index2)).reverse().toString();
//    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length()-1,j=num2.length()-1,carry=0; i>=0 || j>=0 || carry==1; i--,j--) {
           int n1=i<0?0:num1.charAt(i)-'0';
           int n2=j<0?0:num2.charAt(j)-'0';
           int sum = n1+n2+carry;
           sb.insert(0,sum%10);
           carry=sum/10;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new AddStrings().addStrings("9", "99");
        System.out.println(s);
    }
}
