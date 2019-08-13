package com.pigcanfly.leetcoding.s806;

/**
 * @author Tobby Quinn
 * @date 2019/07/30
 */
public class NumberofLinesToWriteString {
    public static int[] numberOfLines(int[] widths, String S) {

        if(S==null || "".equals(S)){
            return new int[]{0,0};
        }
        char[] chars = S.toCharArray();
        int lines=1, res=0;
        for (char c:chars){
            res+=widths[c-'a'];
            if(res>100){
                lines++;
                res=widths[c-'a'];
            }
        }
        return new int[]{lines,res};
    }

    public static void main(String[] args) {

        int[] ints = new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String str = "bbbcccdddaaa";
        numberOfLines(ints,str);
    }
}
