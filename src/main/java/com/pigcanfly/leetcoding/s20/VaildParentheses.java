package com.pigcanfly.leetcoding.s20;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Tobby Quinn
 * @date 2019/06/12
 */
public class VaildParentheses {
    public static boolean isValid(String s) {
        HashMap<Character, Character> dicts = new HashMap<>();
        dicts.put(')', '(');
        dicts.put('}', '{');
        dicts.put(']', '[');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if ('(' == aChar || '{' == aChar || '['== aChar) {
                stack.push(aChar);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                Character popItem = stack.pop();
                if( !popItem.equals(dicts.get(aChar))){
                    return false;
                }
            }

        }
        return stack.size()==0;

    }

    public static void main(String[] args) {
        boolean valid = isValid("([)]");
        System.out.println(valid);
    }
}
