package com.pigcanfly.leetcoding.s942;

/**
 * TODO:贪心算法
 * @author Tobby Quinn
 * @date 2019/07/06
 */
public class DIStringMatch {

    public static int[] diStringMatch(String S) {
        int min=0,max= S.length();
        int[] res = new int[max + 1];
        for (int i = 0; i <S.length(); i++) {
            char c = S.charAt(i);
            if(c=='I'){
                res[i]=min++;
            }
            if(c=='D'){
                res[i]=max--;
            }
            if(i==S.length()-1){
                res[i+1]=c=='I'?min:max;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        diStringMatch("IDID");
    }
}
