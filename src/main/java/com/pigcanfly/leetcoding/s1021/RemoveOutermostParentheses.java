package com.pigcanfly.leetcoding.s1021;

import java.util.Stack;

/**
 *
 * TODO:代码优化，不使用栈
 * (())
 * @author Tobby Quinn
 * @date 2019/06/29
 */
public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        int n = S.length();
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <n ; i++) {
            char c = S.charAt(i);
            boolean isOuterLeftParenthese=false;
            //判断是否有效匹配
            if( ')'==c){
                 stack.pop();
                 if(stack.isEmpty()){
                     isOuterLeftParenthese=false;
                 }
            }else{
                if(stack.isEmpty()){
                    isOuterLeftParenthese=true;
                }
                stack.push(c);
            }

            //判断栈最外层括号不存在,决定拼接字符
            if(!isOuterLeftParenthese && stack.size()!=0){
                //结果添加到StringBuilder
                res.append(c);
            }

        }
        return res.toString();
    }

    public static void main(String[] args) {
        RemoveOutermostParentheses obj = new RemoveOutermostParentheses();
        String s = obj.removeOuterParentheses("(()())(())");
        System.out.println(s);
    }
}
