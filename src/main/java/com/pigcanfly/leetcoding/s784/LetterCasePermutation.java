package com.pigcanfly.leetcoding.s784;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO DFS and BFS
 * @author Tobby Quinn
 * @date 2019/07/12
 */
public class LetterCasePermutation {
    public  static List<String> letterCasePermutation(String S) {
        int len = 0, n = S.length();
        for (int i = 0; i < n; i++) {
            if (!Character.isDigit(S.charAt(i))) {
                len++;
            }
        }
        //无字符
        if(len==0){
            return Arrays.asList(S);
        }
        int resLen = (int) Math.pow(2, len);
        String[] res = new String[resLen];
        int ins=0;
        for (int i = 0; i < n; i++) {
            if (!Character.isDigit(S.charAt(i))) {
                if(ins==0){
                    res[ins++]=S;
                    res[ins++]=replaceIndexUpperOrLower(S,i);
                    continue;
                }
                int currIns=ins;
                for (int j = 0; j < currIns;j++) {
                    res[ins++]=replaceIndexUpperOrLower(res[j],i);
                }
            }
        }
        return Arrays.asList(res);
    }
    private static String  replaceIndexUpperOrLower(String s,int pos){
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(pos);
        if(65<=c && c<=90){
            c = Character.toLowerCase(c);
        }else{
            c = Character.toUpperCase(c);
        }
        String start = s.substring(0,pos);
        String end = s.substring(pos+1);
        sb.append(start);
        sb.append(c);
        sb.append(end);
        return sb.toString();
    }

    // chaifen

    public static List<String> letterCasePermutation1(String S) {
        if (S == null) {
            return new LinkedList<>();
        }

        List<String> res = new LinkedList<>();
        helper1(S.toCharArray(), res, 0);
        return res;
    }

    public static void helper1(char[] chs, List<String> res, int pos) {
        if (pos == chs.length) {
            res.add(new String(chs));
            return;
        }
        if (chs[pos] >= '0' && chs[pos] <= '9') {
            helper1(chs, res, pos + 1);
            return;
        }

        chs[pos] = Character.toLowerCase(chs[pos]);
        helper1(chs, res, pos + 1);

        chs[pos] = Character.toUpperCase(chs[pos]);
        helper1(chs, res, pos + 1);
    }

    //拆分
    public static List<String> letterCasePermutation2(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }

        return new LinkedList<>(queue);
    }



    public static void main(String[] args) {
        String az8 = replaceIndexUpperOrLower("aZ8", 1);
        List<String> a1b2 = letterCasePermutation1("a1b2");
        System.out.println(az8);
    }
}
