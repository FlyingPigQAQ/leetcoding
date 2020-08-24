package com.pigcanfly.leetcoding.s1325;

/**
 * TODO
 * @author tobbyquinn
 * @date 2020/02/13
 */
public class DeleteLeavesWithaGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.left != null) {
            root.left = removeLeafNodes(root.left, target);
        }
        if (root.right != null) {
            root.right = removeLeafNodes(root.right, target);
        }
        return root.left == root.right && root.val == target ? null : root;
    }




    public TreeNode removeLeafNodes1(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        removeLeafNodes1(root.left, target);
        root.left = check(root.left, target);
        removeLeafNodes1(root.right, target);
        root.right = check(root.right, target);
        return check(root, target);
    }

    public TreeNode check(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                return null;
            }
        }
        return root;
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
