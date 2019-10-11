package com.pigcanfly.leetcoding.s541;

/**
 * @author tobbyquinn
 * @date 2019/10/10
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i=i+2*k) {
            int left=i;
            int expectRight=i+k-1;
            int right=expectRight>chars.length-1?chars.length-1:expectRight;
            while(left<right){
                char tmp=chars[left];
                chars[left]=chars[right];
                chars[right]=tmp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
