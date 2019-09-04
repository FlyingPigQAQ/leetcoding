package com.pigcanfly.leetcoding.s748;

/**
 * @author tobbyquinn
 * @date 2019/09/03
 */
public class ShortestCompletingWord {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        int[] dicts = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if(Character.isLetter(c)){
                 c = Character.toLowerCase(c);
                 dicts[c-'a']++;
            }
        }
        String minStr="";
        outer:for (String w:words){
            int[] clone = dicts.clone();
            for (int i = 0; i < w.length(); i++) {
                char c1 = w.charAt(i);
                if(clone[c1-'a']==0){
                    continue;
                }
               clone[c1-'a']--;
            }
            for (int i = 0; i < clone.length; i++) {
                if(clone[i]!=0){
                    continue outer;
                }
            }

            minStr=minStr.equals("")?w:minStr.length()<=w.length()?minStr:w;
        }
        return minStr;
    }

    public static void main(String[] args) {
        String s = shortestCompletingWord("1s3 PSt",
                new String[]{"step", "steps", "stripe", "stepple"});
        System.out.println(s);
    }
}
