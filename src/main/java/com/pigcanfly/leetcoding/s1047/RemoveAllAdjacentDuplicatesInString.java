package com.pigcanfly.leetcoding.s1047;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author tobbyquinn
 * @date 2019/09/26
 */
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        if(S.length()==1){
            return S;
        }
        Stack<Character> q = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char curr = S.charAt(i );
            if(q.isEmpty()){
                q.push(curr);
                continue;
            }
            if(curr==q.peek()){
                q.pop();
            }else {
                q.push(curr);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            sb.insert(0,q.pop());
        }
        return sb.toString();
    }
}
