package com.pigcanfly.leetcoding.s383;

import java.util.HashMap;

/**
 * @author Tobby Quinn
 * @date 2019/07/03
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magz = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if(magz.containsKey(c)){
                magz.put(c,magz.get(c)+1);
            }else{
                magz.put(c,1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if(!magz.containsKey(c) || magz.get(c)==0){
                return false;
            }else{
                magz.put(c,magz.get(c)-1);
            }
        }
        return true;
    }
}
