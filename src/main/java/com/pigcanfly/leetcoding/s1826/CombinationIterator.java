package com.pigcanfly.leetcoding.s1826;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tobbyquinn
 * @date 2020/01/23
 */
public class CombinationIterator {
    private Queue<String> q = new LinkedList<String>();

    public CombinationIterator(String characters, int combinationLength) {
        init(characters, combinationLength, new StringBuilder(), 0);
    }

    public void init(String characters, int combinationLength, StringBuilder sb, int next) {
        if (sb.length() == combinationLength) {
            q.add(sb.toString());
            return;
        }
        for (int i = next; i < characters.length(); i++) {
            sb.append(characters.charAt(i));
            init(characters, combinationLength, sb, i+1);
            //TODO：用完删除
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public String next() {
        return q.poll();

    }

    public boolean hasNext() {
        return !q.isEmpty();
    }

    public static void main(String[] args) {
        CombinationIterator iterator = new CombinationIterator("abc", 1); // creates the iterator.

        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
