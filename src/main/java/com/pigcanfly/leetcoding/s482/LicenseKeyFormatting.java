package com.pigcanfly.leetcoding.s482;

/**
 * @author tobbyquinn
 * @date 2019/11/23
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        if(K==0){
            return "";
        }
        S=S.replaceAll("-","");
        StringBuilder sb = new StringBuilder();
        for (int i = S.length()-1,calK=1; i >=0; i--) {
            sb.append(Character.toUpperCase(S.charAt(i)));
            if(i!=0 &&calK++==K){
                sb.append('-');
                calK=1;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        new LicenseKeyFormatting().licenseKeyFormatting("5F3Z-2e-9-w"
                ,4);
    }
}
