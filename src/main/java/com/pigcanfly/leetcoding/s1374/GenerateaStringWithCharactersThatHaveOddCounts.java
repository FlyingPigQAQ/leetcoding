package com.pigcanfly.leetcoding.s1374;

/**
 * @author tobbyquinn
 * @date 2020/04/07
 */
public class GenerateaStringWithCharactersThatHaveOddCounts {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append("x");
        }
        return n % 2 == 0 ? sb.append("y").toString() : sb.append("x").toString();
    }
}
