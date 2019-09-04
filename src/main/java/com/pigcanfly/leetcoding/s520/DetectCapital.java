package com.pigcanfly.leetcoding.s520;

/**
 * @author Tobby Quinn
 * @date 2019/08/27
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        boolean isFirstCharactUpper = word.charAt(0) >= 'a' ? false : true;
        int lowercases = 0, uppercases = 0, size = word.length();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if ('A' <= c && c <= 'Z') {
                uppercases++;
            } else {
                lowercases++;
            }
        }
        if (uppercases == size || lowercases == size || isFirstCharactUpper && (lowercases == size - 1)) {
            return true;
        }
        return false;
    }
}
