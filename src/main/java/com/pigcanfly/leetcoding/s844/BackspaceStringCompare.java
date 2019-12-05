package com.pigcanfly.leetcoding.s844;

/**
 * @author tobbyquinn
 * @date 2019/10/22
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        int sRight = S.length() - 1, tRight = T.length() - 1;
        while (sRight >= 0 || tRight >= 0) {
            char sc = sRight<0?' ':S.charAt(sRight);
            char tc = tRight<0?' ':T.charAt(tRight);
            int sDelete = 0, tDelete = 0;
            while (sc == '#' || sDelete != 0) {
                if (sc == '#') {
                    sDelete++;
                } else {
                    sDelete--;
                }
                sRight--;
                if (sRight < 0) {
                    sc = ' ';
                    break;
                } else {
                    sc = S.charAt(sRight);
                }
            }
            while (tc == '#' || tDelete != 0) {
                if (tc == '#') {
                    tDelete++;
                } else {
                    tDelete--;
                }
                tRight--;
                if (tRight < 0) {
                    tc = ' ';
                    break;
                } else {
                    tc = T.charAt(tRight);
                }
            }
            if (sc != tc) {
                return false;
            }
            sRight--;
            tRight--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = new BackspaceStringCompare().backspaceCompare("ab#c", "ad#c");
        System.out.println(b);
    }
}
