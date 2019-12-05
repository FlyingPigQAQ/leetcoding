package com.pigcanfly.leetcoding.s32;

import java.util.Stack;

/**
 * TODO:查看各种优秀解法
 * @author tobbyquinn
 * @date 2019/11/04
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean searchSuccess=false;
            if(chars[i]==')'){
                int index=i-1;
                while(index>=0){
                    if(chars[index]==')'){
                        break;
                    }
                    if(chars[index]=='('){
                        chars[index]=' ';
                        searchSuccess=true;
                        break;
                    }
                    index--;
                }
                if(searchSuccess){
                    chars[i]=' ';
                }
            }
        }
        int res=0,tmp=0;
        for (int i = 0; i <chars.length ; i++) {
            if(chars[i]==' '){
                tmp++;
            }else{
                res=Math.max(res,tmp);
                tmp=0;
            }
        }
        return Math.max(res,tmp);
    }

    public static void main(String[] args) {
        int i = new LongestValidParentheses().longestValidParentheses("()(()");
        System.out.println(i);
    }
}
