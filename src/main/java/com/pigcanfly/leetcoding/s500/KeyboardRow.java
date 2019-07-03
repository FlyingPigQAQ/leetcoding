package com.pigcanfly.leetcoding.s500;

import java.util.HashMap;
import java.util.stream.Stream;

/**
 * @author Tobby Quinn
 * @date 2019/07/03
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        HashMap<Character, Integer> dicts = new HashMap<>();
        dicts.put('Q',1);
        dicts.put('W',1);
        dicts.put('E',1);
        dicts.put('R',1);
        dicts.put('T',1);
        dicts.put('Y',1);
        dicts.put('U',1);
        dicts.put('I',1);
        dicts.put('O',1);
        dicts.put('P',1);
        dicts.put('A',2);
        dicts.put('S',2);
        dicts.put('D',2);
        dicts.put('F',2);
        dicts.put('G',2);
        dicts.put('H',2);
        dicts.put('J',2);
        dicts.put('K',2);
        dicts.put('L',2);
        dicts.put('Z',3);
        dicts.put('X',3);
        dicts.put('C',3);
        dicts.put('V',3);
        dicts.put('B',3);
        dicts.put('N',3);
        dicts.put('M',3);
        String[] res = new String[words.length];
        int resIndex=0;
        for (String word:words){
            String s = word.toUpperCase();
            boolean canAdd=true;
            for (int i = 0; i < s.length()-1; i++) {
                char c = s.charAt(i);
                char d = s.charAt(i+1);
                if(!dicts.get(c).equals(dicts.get(d))){
                    canAdd=false;
                    break;
                }
            }
            if(canAdd){
                res[resIndex++]=word;
            }
        }
        String[] finalRes = new String[resIndex];
        System.arraycopy(res,0,finalRes,0,resIndex);
        return finalRes ;
    }
    //TODO
    public String[] findWords1(String[] words) {
        return Stream.of(words).filter(s->s.toUpperCase().matches("[QWERTYUIOP]*|[ASDFGHJKL]*|[ZXCVBNM]*")).toArray(String[]::new);
    }

}
