package com.pigcanfly.leetcoding.s824;

/**
 * @author Tobby Quinn
 * @date 2019/07/11
 */
public class GoatLatin {
    public static String toGoatLatin(String S) {
        String[] s = S.split(" ");
        int i=1;

        for (String ss:s) {
            StringBuilder sb = new StringBuilder();
            if(ss.charAt(0)!='A' && ss.charAt(0)!='a' && ss.charAt(0)!='e' && ss.charAt(0)!='E' &&
                    ss.charAt(0)!='i' && ss.charAt(0)!='I' && ss.charAt(0)!='o' && ss.charAt(0)!='O' &&
                    ss.charAt(0)!='u' && ss.charAt(0)!='U'){
                sb.append(ss.substring(1));
                sb.append(ss.charAt(0));
            }else{
                sb.append(ss);
            }
            sb.append("ma");
            for (int j = 0; j < i; j++) {
                sb.append("a");
            }
            s[i-1]=sb.toString();
            i++;
        }
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < s.length; j++) {
            res.append(s[j]);
            if(j==s.length-1){
                break;
            }
            res.append(" ");
        }
        return res.toString();

    }

    public static void main(String[] args) {
        String i_speak_goat_latin = toGoatLatin("I speak Goat Latin");
        System.out.println("Latin".substring(1));
        System.out.println(i_speak_goat_latin);
    }
}
