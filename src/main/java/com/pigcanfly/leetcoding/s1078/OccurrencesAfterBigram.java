package com.pigcanfly.leetcoding.s1078;

/**
 * @author Tobby Quinn
 * @date 2019/07/06
 */
public class OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        String[] s = text.split(" ");
        String[] res = new String[s.length];
        int len=0;
        for (int i = 0; i < s.length - 2; i++) {
            if(s[i].equals(first) && s[i+1].equals(second)){
                res[i+1]=s[i+2];
                len++;
            }
        }
        String[] finalRes = new String[len];
        int ins=0;
        for (int i = 0; i < res.length; i++) {
            if(res[i]!=null){
                finalRes[ins++]=res[i];
            }
        }
        return finalRes;


    }
}
