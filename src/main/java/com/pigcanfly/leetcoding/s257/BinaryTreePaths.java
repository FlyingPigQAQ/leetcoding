package com.pigcanfly.leetcoding.s257;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2020/02/22
 */
public class BinaryTreePaths {
    List<String> res = new ArrayList<String>();

    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePaths(root, new StringBuilder());
        return res;
    }

    public void binaryTreePaths(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(sb.append(root.val).toString());
            return;
        }

        sb.append(root.val).append("->");
        int start = sb.length();

        binaryTreePaths(root.left, sb);
        sb.delete(start, sb.length());
        binaryTreePaths(root.right, sb);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
