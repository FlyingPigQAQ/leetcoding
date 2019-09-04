package com.pigcanfly.leetcoding.s65;

import java.util.regex.Pattern;

/**
 * TODO：编程实现
 * @author tobbyquinn
 * @date 2019/09/03
 */
public class ValidNumber {
    boolean positive=false,negative=false,exponent=false;
//    public boolean isNumber(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if(c==' '){
//                continue;
//            }
//            if(Character.isLetter(c) && c!='e'){
//                return false;
//            }
//        }
//    }
public static boolean isNumber(String s) {
    return s.matches("\\s*[\\+|\\-]?((\\.[0-9]+)|([0-9]+(\\.[0-9]*)?))(e[+-]?[0-9]+)?\\s*");
}

    public static void main(String[] args) {
        System.out.println(isNumber("+1.5"));
    }
}
