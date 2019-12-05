package com.pigcanfly.leetcoding.s946;

import java.util.Stack;

/**
 * TODO： 精简代码
 * @author Tobby Quinn
 * @date 2019/06/13
 */
public class ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0, popIndex = 0;
       while(pushIndex<pushed.length){
           if(pushed[pushIndex]==popped[popIndex]){
               pushIndex++;
               popIndex++;
           }else if(!stack.isEmpty() && stack.peek()==popped[popIndex]){
               stack.pop();
               popIndex++;
           }else {
               stack.push(pushed[pushIndex++]);
           }
       }
       while(popIndex<popped.length){
           if(stack.isEmpty()){
               return false;
           }else if(stack.peek()==popped[popIndex]){
               stack.pop();
               popIndex++;
           }else{
               return false;
           }
       }
       return stack.isEmpty();
    }

    public static void main(String[] args) {
        validateStackSequences(new int[]{4,0,1,2,3},new int[]{4,2,3,0,1});
    }
}
