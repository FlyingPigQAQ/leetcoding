package com.pigcanfly.leetcoding.s648;

import java.util.List;

/**
 * @author tobbyquinn
 * @date 2020/01/10
 */
public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            String res=word;
            for (int i = 0; i < dict.size(); i++) {
                String s = dict.get(i);
                if(word.startsWith(s)){
                    if(res.length()>s.length()){
                        res=s;
                    }
                }
            }
            sb.append(res).append(" ");
        }
        return sb.toString().trim();
    }
}
