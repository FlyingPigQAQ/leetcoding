package com.pigcanfly.leetcoding.s833;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/11/13
 */
public class FindAndReplaceinString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, String[]> cache = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            cache.put(indexes[i], new String[]{sources[i], targets[i]});
        }
        Arrays.sort(indexes);
        for (int i = 0, index = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (index < indexes.length && indexes[index] == i) {
                String source = cache.get(i)[0];
                for (int j = i, s = 0; s < source.length(); j++, s++) {
                    if (j >= S.length() || source.charAt(s) != S.charAt(j)) {
                        sb.append(c);
                        break;
                    }
                    if (s == source.length() - 1) {
                        sb.append(cache.get(i)[1]);
                        i += source.length() - 1;
                    }
                }
                index++;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "abcd";
//        int[] index = {0, 2};
//        String sources[ "a", "cd"]
//["eee", "ffff"]
//        new FindAndReplaceinString().findReplaceString(s, )
    }
}
