package com.pigcanfly.leetcoding.s1417;

import java.util.LinkedList;

/**
 * @author tobbyquinn
 * @date 2020/05/26
 */
public class ReformatTheString {
    public String reformat(String s) {

        LinkedList<Character> qc = new LinkedList<>();
        LinkedList<Character> qi = new LinkedList<>();
        int digit = 0, letter = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c - '0') < 10) {
                qi.add(c);
                digit++;
            } else {
                qc.add(c);
                letter++;
            }
        }
        if (Math.max(digit, letter) - Math.min(digit, letter) > 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (!qc.isEmpty() || !qi.isEmpty()){
            if(digit<=letter){
                if(qc.size()!=0){
                    sb.append(qc.poll());
                }
                if(qi.size()!=0){
                    sb.append(qi.poll());
                }
            }else{
                if(qi.size()!=0){
                    sb.append(qi.poll());
                }
                if(qc.size()!=0){
                    sb.append(qc.poll());
                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReformatTheString().reformat("covid2019"));
    }
}
