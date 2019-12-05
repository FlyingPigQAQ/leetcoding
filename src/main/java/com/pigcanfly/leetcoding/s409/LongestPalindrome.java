package com.pigcanfly.leetcoding.s409;

/**
 * @author tobbyquinn
 * @date 2019/11/08
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] ints = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //大写字符
            if(c<'a'){
                ints[c-'A']++;
            }else{
                ints[c-'a'+26]++;
            }
        }
        boolean hasSingleWord=false;
        int res=0;
        for (int i : ints) {
            if(i%2==0){
                res+=i;
            }else {
                hasSingleWord=true;
                res+=i-1;
            }
        }
        return hasSingleWord?res+1:res;
    }

    public static void main(String[] args) {
        int abbc = new LongestPalindrome().longestPalindrome("abccccdd");
        System.out.println(abbc);
    }
}
