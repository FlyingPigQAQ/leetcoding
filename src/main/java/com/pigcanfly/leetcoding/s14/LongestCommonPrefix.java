package com.pigcanfly.leetcoding.s14;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author tobbyquinn
 * @date 2019/10/12
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        TreeNode root = new TreeNode(' ');
        for (String str : strs) {
            TreeNode head = root;
            if ("".equals(str)) {
                return "";
            }
            for (int i = 0; i < str.length(); i++) {
                char val = str.charAt(i);
                TreeNode subNode = new TreeNode(val);
                Iterator<TreeNode> iterator = head.next.iterator();
                TreeNode existsNode = null;
                while (iterator.hasNext()) {
                    TreeNode next = iterator.next();
                    if (next.val == val) {
                        existsNode = next;
                    }
                }

                if (existsNode == null) {
                    if (i == str.length() - 1) {
                        subNode.isWordOver = true;
                    }
                    head.next.add(subNode);
                    head = subNode;
                } else {
                    if (i == str.length() - 1) {
                        existsNode.isWordOver=true;
                    }
                    head = existsNode;
                }
            }
        }
        if (root.next.size() != 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        root = root.next.iterator().next();
        while (root.next.size() == 1 && !root.isWordOver) {
            sb.append(root.val);
            root = root.next.iterator().next();
        }
        sb.append(root.val);
        return sb.toString();
    }

    class TreeNode {
        char val;
        boolean isWordOver = false;
        Set<TreeNode> next = new HashSet<>();

        public TreeNode(char val) {
            this.val = val;
        }

        @Override
        public int hashCode() {
            return val;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof TreeNode)) {
                return false;
            }
            if (this.val == ((TreeNode) obj).val) {
                return true;
            } else {
                return false;
            }

        }
    }


    public static void main(String[] args) {
        String s = new LongestCommonPrefix().longestCommonPrefix(new String[]{"aa", "a"});
        System.out.println(s);
        System.out.println("".length());
    }

}
