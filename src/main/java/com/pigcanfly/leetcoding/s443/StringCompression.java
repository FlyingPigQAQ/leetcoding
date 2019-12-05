package com.pigcanfly.leetcoding.s443;

/**
 * Input
 *  ["a","a","b","b","c","c","c"]
 * @author tobbyquinn
 * @date 2019/10/23
 */
public class StringCompression {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        int index=0;
        for (int i = 1, numElements = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                numElements++;
                if(i!=chars.length-1){
                    continue;
                }
            }
            if (numElements > 1) {
                char prev = chars[i - 1];
                char curr = chars[i];
                chars[index++] = chars[i - 1];
                StringBuilder sb = new StringBuilder();
                while (numElements != 0) {
                    int mod = numElements % 10;
                    sb.append(mod);
                    numElements /= 10;
                }
                sb.reverse();
                String s = sb.toString();
                for (int j = 0; j < s.length(); j++) {
                    chars[index++] = s.charAt(j);
                }
                numElements = 1;
                if(i==chars.length-1 &&prev==curr){
                    break;
                }
            } else {
                chars[index++] = chars[i - 1];
            }
            if(i==chars.length-1 ){
                chars[index++] = chars[i];
            }
        }
        return index;
    }

    public int compress1(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        new StringCompression().compress1(new char[]{'b','b','a'});
    }
}
