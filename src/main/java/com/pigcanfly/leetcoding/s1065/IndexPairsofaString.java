package com.pigcanfly.leetcoding.s1065;

import java.util.Arrays;

/**TODO :后期修改
 * @author tobbyquinn
 * @date 2020/01/10
 */
public class IndexPairsofaString {
    public int[][] indexPairs(String text, String[] words) {
        Integer[][] res = new Integer[1000][2];
        int index = 0;
        for (String word : words) {
            if (text.length() < word.length()) {
                continue;
            }
            outer:
            for (int i = 0; i <= text.length() - word.length(); i++) {
                for (int j = 0; j < word.length(); j++) {
                    char c1 = word.charAt(j);
                    char c2 = text.charAt(j + i);
                    if (c1 != c2) {
                        continue outer;
                    }
                }
                res[index++] = new Integer[]{i, i + word.length() - 1};
            }
        }
        Arrays.sort(res, (c1, c2) -> {
            if (c1[0] == null) {
                return 1;
            } else if (c2[0] == null) {
                return -1;
            }
            return c1[0].equals(c2[0]) ? Integer.compare(c1[1], c2[1]) : Integer.compare(c1[0], c2[0]);
        });
        int[][] resClone = new int[index][2];
        index = 0;
        for (Integer[] re : res) {
            if (re[0] == null) {
                continue;
            }
            resClone[index++] = new int[]{re[0], re[1]};
        }
        return resClone;
    }

    public static void main(String[] args) {
        new IndexPairsofaString().indexPairs("thestoryofleetcodeandme",
                new String[]{"story", "fleet", "leetcode"});
    }
}
