package com.pigcanfly.leetcoding.s6;

/**
 * @author Tobby Quinn
 * @date 2019/07/26
 */
public class ZiZagConversion {
    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        if(numRows==1){
            return s;
        }
        int len = chars.length, zz = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int start = i;
            boolean zigZag = true;
            for (; ; ) {
                if (start > len - 1) {
                    zigZag=true;
                    break;
                }
                sb.append(chars[start]);
                if (i == 0 || i == numRows - 1) {
                    start += zz;
                } else {
                    if (zigZag) {
                        start += zz - 2 * i;
                        zigZag = false;
                    } else {
                        start += 2*i;
                        zigZag = true;
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * 创建Nrow个StringBuilder(),将每个字符放到不同的sb对象里面，Good Idea!
     * @param s
     * @param numRows
     * @return
     */
    public static String convert1(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) sbs[i] = new StringBuilder();
        int idx = 0;
        int direction = -1;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            sbs[idx].append(c);
            if (idx == 0 || idx == numRows - 1) direction = 0 - direction;
            idx += direction;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbs) res.append(sb);
        return res.toString();
    }

    public static void main(String[] args) {
        convert1("PAHNAPLSIIGYIR",4);
    }
}
