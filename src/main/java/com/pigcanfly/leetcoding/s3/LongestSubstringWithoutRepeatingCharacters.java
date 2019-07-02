package com.pigcanfly.leetcoding.s3;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO：
 *
 * @author Tobby Quinn
 * @date 2019/06/27
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }
        int result = 1, length = 0, n = s.length();
        HashMap<Character, Integer> cache;
        for (int i = 0; i < n; i++) {
            cache = new HashMap<>();
            for (int j = i; j < n; j++) {
                if (cache.containsKey(s.charAt(j))) {
                    result = Math.max(result, length);
                    length = 0;
                    break;
                }
                if (j == s.length() - 1) {
                    result = Math.max(result, ++length);
                    length = 0;
                    break;
                }
                cache.put(s.charAt(j), 1);
                length++;
            }

        }
        return result;

    }


    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        // current index of character
        // try to extend the range [i, j]

        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                //优化紧邻的相同元素
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int r = lengthOfLongestSubstring("au");
        System.out.println(r);
    }
}
