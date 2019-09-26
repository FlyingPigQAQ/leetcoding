package com.pigcanfly.leetcoding.s1189;

/**
 * @author tobbyquinn
 * @date 2019/09/26
 */
public class MaximumNumberofBalloons {
    public int maxNumberOfBalloons(String text) {
        char[] chars = new char[5];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c){
                case 'b':
                    chars[0]++;
                    break;
                case 'a':
                    chars[1]++;
                    break;
                case 'l':
                    chars[2]++;
                    break;
                case 'o':
                    chars[3]++;
                    break;
                case 'n':
                    chars[4]++;
                    break;
                default:
                    break;
            }
        }
        int res=chars[0];
        for (int i = 1; i < chars.length; i++) {
            if(i==2 || i==3){
                res=Math.min(res,chars[i]/2);
            }else {
                res = Math.min(res, chars[i]);
            }
        }
        return res;
    }
}
