package com.pigcanfly.leetcoding.s422;

import com.pigcanfly.other.KettleQuestion;

import java.util.List;

/**
 * @author tobbyquinn
 * @date 2020/05/13
 */
public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        int maxColumnLength=Integer.MIN_VALUE;
        for (String word : words) {
            maxColumnLength=Math.max(maxColumnLength,word.length());
        }
        int k=Math.max(maxColumnLength,words.size());
        for (int i = 0; i < k; i++) {
            String row=words.get(i);
            StringBuilder column=new StringBuilder();
            for (int j = 0; j < k; j++) {
                if(words.size()>j && words.get(j).length()>i){
                    column.append(words.get(j).charAt(i));
                }
            }
            if(!row.equals(column.toString())){
                return false;
            }
        }
        return true;
    }
}
