package com.pigcanfly.leetcoding.s58;

/**
 * @author Tobby Quinn
 * @date 2019/06/13
 */
public class LengthOfLastWord {
    //单个空格，单个字符，空格开始，空格结尾
    public static int lengthOfLastWord1(String s) {
        String[] s1 = s.split(" ");
        return s1.length>0?s1[s1.length-1].length():0;

    }
    public static int lengthOfLastWord(String s) {
        int wordStart=-1;
        int wordEnd=-1;
        boolean continueWord=false;
        for (int i = 0; i < s.length(); i++) {
            char at = s.charAt(i);
            if(at==' '){
                if(continueWord){
                    continueWord=false;
                    wordEnd=i;
                }
            }else{
                if(!continueWord){
                    wordStart=i;
                    continueWord=true;
                }
            }
        }
        return continueWord?s.length()-wordStart:wordEnd-wordStart;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" hello  www "));
    }
}
