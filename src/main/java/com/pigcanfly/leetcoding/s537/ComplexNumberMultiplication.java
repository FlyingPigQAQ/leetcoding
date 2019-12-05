package com.pigcanfly.leetcoding.s537;

/**
 * @author tobbyquinn
 * @date 2019/10/30
 */
public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        String[] aSplits = a.substring(0, a.length() - 1).split("\\+");
        String[] bSplits = b.substring(0, b.length() - 1).split("\\+");
        int a0 = Integer.parseInt(aSplits[0]), a1 = Integer.parseInt(aSplits[1]),
                b0 = Integer.parseInt(bSplits[0]), b1 = Integer.parseInt(bSplits[1]);
        int first = a0 * b0 + a1 * b1 * -1;
        int second = a0 * b1 + a1 * b0;
        return ""+first+"+"+second+"i";
    }
}
