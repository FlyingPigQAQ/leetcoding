package com.pigcanfly.leetcoding.s804;

import java.util.HashSet;

/**
 * @author Tobby Quinn
 * @date 2019/06/30
 */
public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] dicts = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> set = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (String word:words){
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                sb.append(dicts[c-'a']);
            }
            set.add(sb.toString());
            sb.delete(0,sb.length());
        }

        return set.size();
    }

    public static void main(String[] args) {
        UniqueMorseCodeWords obj = new UniqueMorseCodeWords();
        obj.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
    }
}
