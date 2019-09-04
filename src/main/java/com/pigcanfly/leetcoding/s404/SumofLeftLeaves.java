package com.pigcanfly.leetcoding.s404;

/**
 * @author tobbyquinn
 * @date 2019/08/29
 */
public class SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        return (isLeft && root.left == null && root.right == null ? root.val : 0) + (sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false));
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

