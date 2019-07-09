package com.pigcanfly.leetcoding.s965;

/**
 * @author Tobby Quinn
 * @date 2019/07/08
 */
public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int digit = root.val;
        return isUnivalTree(digit, root);
    }

    public boolean isUnivalTree(int rootVal, TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val != rootVal) {
            return false;
        }
        return isUnivalTree(rootVal, root.left) && isUnivalTree(rootVal, root.right);

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
