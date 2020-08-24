package com.pigcanfly.leetcoding.s1309;

/**
 * @author tobbyquinn
 * @date 2020/01/10
 */
public class DecryptStringfromAlphabettoIntegerMapping {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '#') {
                flag = true;
                i--;
            } else {
                if (flag) {
                    int idx = Character.getNumericValue(c) * 10 + Character.getNumericValue(s.charAt(i + 1));
                    sb.append( (char)('a'+idx-1));
                    flag=false;
                }else{
                    int idx = Character.getNumericValue(c);
                    sb.append((char)('a'+idx-1));
                }
            }
        }
        return sb.reverse().toString();
    }
}
