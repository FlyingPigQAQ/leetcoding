package com.pigcanfly.leetcoding.s993;

/**
 * @author tobbyquinn
 * @date 2019/10/10
 */
public class CousinsinBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] res = new int[2];
        return isCousins(root, x, y, 0, res) && res[0] == res[1];
    }

    public boolean isCousins(TreeNode root, int x, int y, int depth, int[] depths) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            if (root.left.val == x && root.right.val == y || root.left.val == y && root.right.val == x) {
                return false;
            }
        }
        if (root.val == x || root.val == y) {
            if (depths[0] == 0) {
                depths[0] = depth;
            } else {
                depths[1] = depth;
            }
        }
        return isCousins(root.left, x, y, depth + 1, depths) && isCousins(root.right, x, y, depth + 1, depths);
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
