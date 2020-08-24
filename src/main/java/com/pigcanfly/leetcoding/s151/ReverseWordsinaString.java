package com.pigcanfly.leetcoding.s151;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2020/07/30
 */
public class ReverseWordsinaString {
    public String reverseWordsV1(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.trim().split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.insert(0, arr[i]);
            } else {
                sb.insert(0, " " + arr[i]);
            }
        }
        return sb.toString();
    }
    public String reverseWordsV2(String s) {
        String[] arr = s.trim().split("\\s+");
        List<String> res = Arrays.asList(arr);
        Collections.reverse(res);
        return String.join(" ",res);
    }

    public static void main(String[] args) {
        for (String s : "  hello  world  ".trim().split("\\s+")) {
            System.out.println(s);
        }
    }
}
