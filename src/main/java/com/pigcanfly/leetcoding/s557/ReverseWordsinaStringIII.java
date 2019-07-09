package com.pigcanfly.leetcoding.s557;

import java.util.Stack;

/**
 * @author Tobby Quinn
 * @date 2019/07/05
 */
public class ReverseWordsinaStringIII {

    public String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c==' '){
                while(!stack.isEmpty()){
                    res.append(stack.pop());
                }
               res.append(' ');
               continue;
            }
            stack.push(c);
        }
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();
    }
}
