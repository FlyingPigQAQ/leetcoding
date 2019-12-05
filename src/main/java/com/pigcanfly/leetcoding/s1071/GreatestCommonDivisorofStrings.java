package com.pigcanfly.leetcoding.s1071;

/**
 * @author tobbyquinn
 * @date 2019/10/20
 */
public class GreatestCommonDivisorofStrings {
    public String gcdOfStrings1(String str1, String str2) {
        if (str1 == str2) {
            return str1;
        }else if(!(str1+str2).equals((str2+str1))){
            return "";
        }
        String minStr = str2, maxStr = str1;
        if (str1.length() < str2.length()) {
            minStr = str1;
            maxStr = str2;
        }
        int max = maxStr.length(), min = minStr.length();
        int i;
        for ( i = min; i >= 1; i--) {
            if (max % i != 0 || min % i != 0) {
                continue;
            }
            break;
        }
        return minStr.substring(0, i);
    }

//    public String gcdOfStrings(String str1, String str2) {
//        if (!(str1+str2).equals(str2+str1)) {
//            return "";
//        }
//        int len = str1.length();
//        int len2 = str2.length();
//        int gcd = GCD(len, len2);
//        if (len < len2) {
//            return str1.substring(0, gcd);
//        }
//        return str2.substring(0, gcd);
//    }
//
//    public int GCD(int a, int b) {
//        if (b == 0) {
//            return a;
//        }
//        return a % b == 0 ? b : GCD(b, a % b);
//    }

    public static void main(String[] args) {
        String s = new GreatestCommonDivisorofStrings().gcdOfStrings1("ABBA", "AB");
        System.out.println(s);
    }
}
