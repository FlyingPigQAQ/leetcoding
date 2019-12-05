package com.pigcanfly.leetcoding.s345;

import java.util.HashSet;

/**
 * @author tobbyquinn
 * @date 2019/11/22
 */
public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        if(s==null || "".equals(s)){
            return s;
        }
        HashSet<Character> characters = new HashSet<>();
        characters.add('A');
        characters.add('a');
        characters.add('E');
        characters.add('e');
        characters.add('I');
        characters.add('i');
        characters.add('O');
        characters.add('o');
        characters.add('U');
        characters.add('u');
        char[] chars = s.toCharArray();
        int left=0,right=s.length()-1;
        while (left<right){
            if(!characters.contains(chars[left])){
                left++;
            }else if(!characters.contains(chars[right])){
                right--;
            }else {
                char tmp =chars[left];
                chars[left]=chars[right];
                chars[right]=tmp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
